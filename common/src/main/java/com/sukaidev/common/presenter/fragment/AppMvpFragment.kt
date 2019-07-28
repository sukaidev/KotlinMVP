package com.sukaidev.common.presenter.fragment

import android.os.Bundle
import com.sukaidev.common.App
import com.sukaidev.common.injection.component.ActivityComponent
import com.sukaidev.common.injection.component.DaggerActivityComponent
import com.sukaidev.common.injection.component.LifecycleProviderModule
import com.sukaidev.common.injection.module.ActivityModule
import com.sukaidev.common.presenter.AppPresenter
import com.sukaidev.common.presenter.view.AppView
import javax.inject.Inject

/**
 * Created by sukaidev on 2019/07/28.
 *
 */
abstract class AppMvpFragment<T : AppPresenter<*>> : AppFragment(), AppView {

    /**
     * activity持有presenter
     */
    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragmentInjection()
        injectComponent()
    }

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

    abstract fun injectComponent()

    private fun initFragmentInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((activity?.application as App).appComponent)
            .activityModule(ActivityModule(this.activity!!))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }
}