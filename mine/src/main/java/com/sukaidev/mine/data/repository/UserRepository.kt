package com.sukaidev.mine.data.repository

import com.sukaidev.common.http.HttpHelper
import com.sukaidev.common.http.entity.Think
import com.sukaidev.mine.data.api.UserApi
import com.sukaidev.mine.data.entity.LoginRequest
import com.sukaidev.mine.data.entity.RegisterRequest
import com.sukaidev.mine.data.entity.UserInfo
import rx.Observable
import javax.inject.Inject

/**
 * Created by sukaidev on 2019/07/30.
 *
 */
class UserRepository @Inject constructor() {

    /**
     * 用户登录
     */
    fun login(phone: String, pwd: String): Observable<Think<UserInfo>> {
        return HttpHelper.instance.create(UserApi::class.java).login(LoginRequest(phone, pwd))
    }

    /**
     * 用户注册
     */
    fun register(username: String, pwd: String, verifyCode: String): Observable<Think<String>> {
        return HttpHelper.instance.create(UserApi::class.java).register(RegisterRequest(username, pwd, verifyCode))
    }
}