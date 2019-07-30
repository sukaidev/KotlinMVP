package com.sukaidev.mine.presenter.view

import com.sukaidev.common.presenter.view.AppView
import com.sukaidev.mine.data.entity.UserInfo

/**
 * Created by sukaidev on 2019/07/30.
 *
 */
interface LoginView : AppView {

    /**
     * 用户登录回调
     */
    fun loginResult(result: UserInfo)
}