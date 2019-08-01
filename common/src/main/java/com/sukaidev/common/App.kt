package com.sukaidev.common

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.sukaidev.common.injection.component.AppComponent
import com.sukaidev.common.injection.component.DaggerAppComponent
import com.sukaidev.common.injection.module.AppModule

/**
 * Created by sukaidev on 2019/07/28.
 *
 */
class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppInjection()

        context = this

        //Arouter初始化
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var context: Context
    }
}