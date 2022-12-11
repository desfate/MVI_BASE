package com.live.allo.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import java.util.prefs.Preferences

public const val USER_PREFERENCES_SEARCH = "market_preferences"

// 基于文件的轻量化数据存储模块
//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES_SEARCH)

//val msgSystemData = intPreferencesKey("system_msg_data")
