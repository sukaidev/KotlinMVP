package com.sukaidev.mine.injection.component

import com.sukaidev.common.injection.component.ActivityComponent
import com.sukaidev.common.injection.scope.PreComponentScope
import com.sukaidev.mine.injection.module.UserModule
import com.sukaidev.mine.presenter.activity.LoginActivity
import com.sukaidev.mine.presenter.activity.RegisterActivity
import dagger.Component

/**
 * Created by sukaidev on 2019/07/30.
 *
 */
@PreComponentScope
@Component(
    dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(UserModule::class)
)
interface UserComponent {
    fun inject(activity: LoginActivity)

    fun inject(activity: RegisterActivity)
}
