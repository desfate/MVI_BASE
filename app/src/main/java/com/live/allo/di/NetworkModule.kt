package com.live.allo.di

import com.live.allo.business.api.RxTestService
import com.live.allo.business.api.TestService
import com.live.allo.net.HttpEngine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 网络核心module 单例
 */
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun testService(): TestService {
        return HttpEngine.instance.create(TestService::class.java)
    }

    @Singleton
    @Provides
    fun rxTestService(): RxTestService {
        return HttpEngine.instance.create(RxTestService::class.java)
    }

}