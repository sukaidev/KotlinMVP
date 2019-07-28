package com.sukaidev.common.injection.component

import android.content.Context
import com.sukaidev.common.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sukaidev on 2019/07/28.
 *
 */
/**
 * App 全局Component 主要是注入全局context
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}