package com.live.allo

import android.app.Application
import android.content.Context
import com.live.allo.business.models.TestData
import com.tencent.mmkv.MMKV

open class BaseApplication: Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        val rootDir = MMKV.initialize(this)


        MMKV.defaultMMKV().encode("TEST", TestData(1, "testName"))
    }

}