package com.sukaidev.common.presenter.fragment

import com.sukaidev.common.presenter.AppPresenter
import com.sukaidev.common.presenter.view.AppView

/**
 * Created by sukaidev on 2019/07/28.
 *
 */
abstract class AppMvpFragment<T : AppPresenter<*>> : AppFragment(), AppView {

    /**
     * activity持有presenter
     */
    lateinit var mPresenter: T

    /**
     * 显示加载框的默认实现
     */
    override fun showLoading() {

    }

    /**
     * 显示加载框的默认实现
     */
    override fun hideLoading() {

    }

    /**
     * 显示加载框的默认实现
     */
    override fun onError(message: String) {

    }
}