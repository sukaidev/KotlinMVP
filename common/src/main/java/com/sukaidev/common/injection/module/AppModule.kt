package com.sukaidev.common.injection.module

import android.content.Context
import com.sukaidev.common.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sukaidev on 2019/07/28.
 *
 */
@Module
class AppModule(private val context: App) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }
}