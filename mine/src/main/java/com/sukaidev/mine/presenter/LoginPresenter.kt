package com.sukaidev.mine.presenter

import com.sukaidev.common.presenter.AppPresenter
import com.sukaidev.mine.presenter.view.LoginView
import com.zyao89.view.zloading.Z_TYPE
import javax.inject.Inject

/**
 * Created by sukaidev on 2019/07/30.
 * 登录presenter.
 */
class LoginPresenter @Inject constructor() : AppPresenter<LoginView>() {

    fun login(userName: String, password: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading(Z_TYPE.SNAKE_CIRCLE)
    }
}