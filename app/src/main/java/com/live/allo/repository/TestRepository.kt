package com.live.allo.repository

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.lifecycle.LifecycleOwner
import autodispose2.AutoDispose
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider
import com.live.allo.MineApplication
import com.live.allo.business.api.RxTestService
import com.live.allo.business.api.TestService
import com.live.allo.business.models.request.TestRequest
import com.live.allo.database.dao.UserInfoDao
import com.live.allo.di.dataStore
import com.live.allo.di.msgSystemData
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
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
    private val userDao: UserInfoDao,
) {

    /**
     * 异步获取服务接口数据
     */
    suspend fun getTestReq(testRequest: TestRequest) {
        testService.testReq(testRequest)
    }

    /**
     * rxjava 获取网路请求  返回Flowable对象
     */
    fun getTestReqRx(testRequest: TestRequest, lifecycleOwner: LifecycleOwner) =
        rxTestService.orderPay(testRequest).subscribeOn(Schedulers.io()).observeOn(Schedulers.io())
            .to(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))

    /**
     * 写入string信息
     */
    suspend fun setMsg(msg: String) = MineApplication.instance.applicationContext.dataStore.edit {
        it[msgSystemData] = msg
    }

    /**
     * 获取string信息
     */
    fun getMsg() = MineApplication.instance.applicationContext.dataStore.data.map {
        val msg = it[msgSystemData]?: ""
        msg
    }



}