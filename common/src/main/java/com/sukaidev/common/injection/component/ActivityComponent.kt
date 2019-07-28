package com.sukaidev.common.injection.component

import android.app.Activity
import android.content.Context
import com.sukaidev.common.injection.module.ActivityModule
import com.sukaidev.common.injection.scope.ActivityScope
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * Created by sukaidev on 2019/07/28.
 *
 */
@ActivityScope
@Component(
    dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(ActivityModule::class, LifecycleProviderModule::class)
)
interface ActivityComponent {
    /**
     * Component管理Inject标注的构造函数的Activity
     */
    fun activity(): Activity

    /**
     * Component管理Inject标注的构造函数的Context
     */
    fun context(): Context

    /**
     * Component管理Inject标注的构造函数的生命周期管理器
     */
    fun lifecycleProvider(): LifecycleProvider<*>
}