package com.live.allo.repository

import androidx.lifecycle.LifecycleOwner
import autodispose2.AutoDispose
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider
import com.live.allo.business.api.RxTestService
import com.live.allo.business.api.TestService
import com.live.allo.business.models.request.TestRequest
import com.live.allo.database.dao.UserInfoDao
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 资源仓库 所有数据的来源管理
 * 1. 网络请求来源  基于 Service
 * 2. 数据库来源    基于 Dao
 * 3. 文件来源     基于 context.dataStore
 */
@Singleton
class TestRepository @Inject constructor(
    private val testService: TestService,
    private val rxTestService: RxTestService,
    private val userDao: UserInfoDao
) {

    suspend fun getTestReq(testRequest: TestRequest) {
        testService.testReq(testRequest)
    }

    fun getTestReqRx(testRequest: TestRequest, lifecycleOwner: LifecycleOwner) =
        rxTestService.orderPay(testRequest).subscribeOn(Schedulers.io()).observeOn(Schedulers.io())
            .to(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))

}