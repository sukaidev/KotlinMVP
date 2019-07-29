package com.sukaidev.common.http

import com.sukaidev.common.common.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by sukaidev on 2019/07/28.
 *
 */
class HttpHelper {
    companion object {
        val instance: HttpHelper by lazy {
            HttpHelper()
        }
    }

    private val retrofit: Retrofit

    private val interceptor: Interceptor

    init {
        /**
         * 设置请求头
         */
        interceptor = Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Content_Type", "application/json")
                .addHeader("charset", "UTF-8")
                .addHeader("token", AppPrefsUtils.getString(Constant.KEY_SP_TOKEN))
                .build()
            chain.proceed(request)
        }

        /**
         * 构建Retrofit
         */
        retrofit = Retrofit.Builder()
            // 全局接口Url
            .baseUrl(Constant.SERVER_ADDRESS)
            //数据处理
            .addConverterFactory(GsonConverterFactory.create())
            //数据适配器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            //初始化HTTP Client
            .client(initClient())
            .build()
    }

    /**
     *  初始化http client
     */
    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            //日志拦截器
            .addInterceptor(initLogInterceptor())
            //添加自定义拦截器
            .addInterceptor(interceptor)
            //连接超时
            .connectTimeout(10, TimeUnit.SECONDS)
            //读取超时
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    /**
     *  初始化日志拦截器
     */
    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        //设置日志级别
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

}

