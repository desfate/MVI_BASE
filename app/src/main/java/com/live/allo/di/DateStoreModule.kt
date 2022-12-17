package com.live.allo.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

const val USER_PREFERENCES_SEARCH = "test_preferences"

// 基于文件的轻量化数据存储模块
//val Context.dataStore by preferencesDataStore(name = USER_PREFERENCES_SEARCH)

// 'settings' 是存储在本地的文件名
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES_SEARCH)

val msgSystemData = stringPreferencesKey("system_msg_data")


