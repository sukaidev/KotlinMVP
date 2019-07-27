package com.sukaidev.common.presenter.activity

import com.sukaidev.common.presenter.AppPresenter
import com.sukaidev.common.presenter.view.AppView

/**
 * Created by sukaidev on 2019/07/27.
 *
 */
abstract class AppMvpActivity<P : AppPresenter<*>> : AppActivity(), AppView {

    /**
     * activity持有presenter
     */
    lateinit var mPresenter: P

    /**
     * 显示加载框的默认实现
     */
    override fun showLoading() {

    }

    /**
     * 隐藏加载框的默认实现
     */
    override fun hideLoading() {

    }

    /**
     * 错误信息的默认实现
     */
    override fun onError(message: String) {

    }
}