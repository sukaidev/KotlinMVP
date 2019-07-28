package com.sukaidev.common.presenter.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.sukaidev.common.App
import com.sukaidev.common.injection.component.ActivityComponent
import com.sukaidev.common.injection.component.AppComponent
import com.sukaidev.common.injection.component.DaggerActivityComponent
import com.sukaidev.common.injection.component.LifecycleProviderModule
import com.sukaidev.common.injection.module.ActivityModule
import com.sukaidev.common.presenter.AppPresenter
import com.sukaidev.common.presenter.view.AppView
import javax.inject.Inject

/**
 * Created by sukaidev on 2019/07/27.
 *
 */
abstract class AppMvpActivity<P : AppPresenter<*>> : AppActivity(), AppView {

    /**
     * activity持有presenter
     */
    @Inject
    lateinit var mPresenter: P

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initActivityInjection()
        injectComponent()
    }

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

    /**
     * 依赖注解子类强制实现
     */
    abstract fun injectComponent()

    /**
     * 初始化依赖注解
     */
    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as App).appComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }
}