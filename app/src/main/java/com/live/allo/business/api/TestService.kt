package com.live.allo.business.api

import com.live.allo.business.models.request.TestRequest
import com.live.allo.business.models.response.TestResponse
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 接口相关信息
 */
interface TestService {
    @POST("pay/orderPay")
    suspend fun testReq(@Body req: TestRequest): TestResponse
}