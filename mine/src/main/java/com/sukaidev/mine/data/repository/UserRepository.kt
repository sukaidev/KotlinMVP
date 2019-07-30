package com.sukaidev.mine.data.repository

import com.sukaidev.common.http.HttpHelper
import com.sukaidev.common.http.entity.Think
import com.sukaidev.mine.data.api.UserApi
import com.sukaidev.mine.data.entity.LoginRequest
import com.sukaidev.mine.data.entity.UserInfo
import rx.Observable

/**
 * Created by sukaidev on 2019/07/30.
 *
 */
class UserRepository {

    /**
     * 用户登录
     */
    fun login(phone: String, pwd: String): Observable<Think<UserInfo>> {
        return HttpHelper.instance.create(UserApi::class.java).login(LoginRequest(phone, pwd))
    }
}