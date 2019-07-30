package com.sukaidev.mine.service

import com.sukaidev.mine.data.entity.UserInfo
import rx.Observable

/**
 * Created by sukaidev on 2019/07/30.
 *
 */
interface UserService {
    fun login(userName:String,password:String,pushId:String): Observable<UserInfo>?
}