package com.sukaidev.kotlinmvp.injection.module

import com.sukaidev.kotlinmvp.service.MainService
import com.sukaidev.kotlinmvp.service.impl.MainServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by sukaidev on 2019/08/01.
 *
 */
@Module
class MainModule {
    @Provides
    fun providesMainService(service: MainServiceImpl): MainService {
        return service
    }
}