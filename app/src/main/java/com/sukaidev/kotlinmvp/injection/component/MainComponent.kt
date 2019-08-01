package com.sukaidev.kotlinmvp.injection.component

import com.sukaidev.common.injection.component.ActivityComponent
import com.sukaidev.common.injection.scope.PreComponentScope
import com.sukaidev.kotlinmvp.injection.module.MainModule
import com.sukaidev.kotlinmvp.presenter.activity.MainActivity
import dagger.Component

/**
 * Created by sukaidev on 2019/08/01.
 *
 */
@PreComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}