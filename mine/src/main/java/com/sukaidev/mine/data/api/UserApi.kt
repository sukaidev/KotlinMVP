package com.sukaidev.mine.data.api

import com.sukaidev.common.http.entity.Think
import com.sukaidev.mine.data.entity.LoginRequest
import com.sukaidev.mine.data.entity.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by sukaidev on 2019/07/30.
 * 用户相关接口.
 */
interface UserApi {

    /**
     * 用户登录
     */
    @POST("userCenter/login")
    fun login(@Body req: LoginRequest): Observable<Think<UserInfo>>
}