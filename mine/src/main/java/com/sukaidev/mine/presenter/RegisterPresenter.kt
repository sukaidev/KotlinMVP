package com.sukaidev.mine.presenter

import com.sukaidev.common.ext.execute
import com.sukaidev.common.presenter.AppPresenter
import com.sukaidev.common.rx.BaseSubscriber
import com.sukaidev.mine.presenter.view.RegisterView
import com.sukaidev.mine.service.UserService
import com.zyao89.view.zloading.Z_TYPE
import javax.inject.Inject

/**
 * Created by sukaidev on 2019/08/01.
 * 注册presenter.
 */
class RegisterPresenter @Inject constructor() : AppPresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(userName: String, pwd: String, verifyCode: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading(Z_TYPE.STAIRS_PATH)
        userService.register(userName, pwd, verifyCode).execute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t) {
                    mView.onRegisterResult("注册成功")
                }
            }
        }, lifecycleProvider)
    }
}