package com.live.allo

import dagger.hilt.android.HiltAndroidApp
import kotlin.properties.Delegates

@HiltAndroidApp
class MineApplication: BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: MineApplication by Delegates.notNull()
    }
}