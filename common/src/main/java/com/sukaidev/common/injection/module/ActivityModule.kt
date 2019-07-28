package com.sukaidev.common.injection.module

import android.app.Activity
import com.sukaidev.common.injection.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by sukaidev on 2019/07/28.
 *
 */
@Module
class ActivityModule(private val activity: Activity) {

    /**
     * 创建Activity实例
     */
    @Provides
    @ActivityScope
    fun providesActivity(): Activity {
        return activity
    }
}