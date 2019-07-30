package com.sukaidev.mine.service.impl

import com.sukaidev.common.ext.convert
import com.sukaidev.mine.data.entity.UserInfo
import com.sukaidev.mine.data.repository.UserRepository
import com.sukaidev.mine.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * Created by sukaidev on 2019/07/30.
 *
 */
class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun login(userName: String, password: String, pushId: String): Observable<UserInfo> {
        return repository.login(userName, password).convert()
    }
}