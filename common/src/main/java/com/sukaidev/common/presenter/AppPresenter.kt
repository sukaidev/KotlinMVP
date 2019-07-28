package com.sukaidev.common.presenter

import android.content.Context
import com.sukaidev.common.presenter.view.AppView
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * Created by sukaidev on 2019/07/27.
 *
 */
open class AppPresenter<V : AppView> {

    lateinit var mView: V

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context
}