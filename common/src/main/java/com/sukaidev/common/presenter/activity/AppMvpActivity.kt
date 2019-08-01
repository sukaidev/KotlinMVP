package com.sukaidev.common.presenter.activity

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import com.sukaidev.common.App
import com.sukaidev.common.R
import com.sukaidev.common.injection.component.ActivityComponent
import com.sukaidev.common.injection.component.AppComponent
import com.sukaidev.common.injection.component.DaggerActivityComponent
import com.sukaidev.common.injection.component.LifecycleProviderModule
import com.sukaidev.common.injection.module.ActivityModule
import com.sukaidev.common.presenter.AppPresenter
import com.sukaidev.common.presenter.view.AppView
import com.tapadoo.alerter.Alerter
import com.zyao89.view.zloading.ZLoadingDialog
import com.zyao89.view.zloading.Z_TYPE
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

    lateinit var dialog: ZLoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化ZLoadingDialog
        dialog = ZLoadingDialog(this)
        initActivityInjection()
        injectComponent()
    }

    /**
     * 显示加载框的默认实现
     */
    override fun showLoading(TYPE: Z_TYPE) {
        dialog.setLoadingBuilder(TYPE)//设置类型
            .setLoadingColor(Color.BLACK)//颜色
            .setHintText("Loading...")
            .setHintTextColor(Color.GRAY)  // 设置字体颜色
            .setDurationTime(1.0) // 设置动画时间百分比 - 0.5倍
            .setCanceledOnTouchOutside(false)
            .show()
    }

    /**
     * 隐藏加载框的默认实现
     */
    override fun hideLoading() {
        dialog.cancel()
    }

    /**
     * 错误信息的默认实现
     */
    override fun onError(message: String) {
        Alerter.create(this)
            .setTitle("消息通知")
            .setText(message)
            .enableSwipeToDismiss()
            .setDuration(10000)
            .setBackgroundColorRes(R.color.alert_error_bg)
            .setIcon(R.drawable.alert_error_icon)
            .show()
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