package com.sukaidev.common.presenter

import com.sukaidev.common.presenter.view.AppView

/**
 * Created by sukaidev on 2019/07/27.
 *
 */
open class AppPresenter<V : AppView> {
    lateinit var mView: V
}