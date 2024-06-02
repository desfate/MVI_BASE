package com.live.allo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.live.allo.business.models.TestData
import com.live.allo.repository.TestRepository
import com.tencent.mmkv.MMKV
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val testRepository: TestRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    init {
        val testData = MMKV.defaultMMKV().decodeParcelable("TEST", TestData::class.java)
        _text.postValue(testData?.name)
    }
}