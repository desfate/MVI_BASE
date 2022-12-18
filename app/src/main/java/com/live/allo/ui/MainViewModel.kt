package com.live.allo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.live.allo.repository.TestRepository
import com.live.allo.utils.Async
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainUiState(
    val submitText: String? = "",
    val isShowLoading: Boolean = false
)

@HiltViewModel
class MainViewModel @Inject constructor(private val testRepository: TestRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    private val _submitBtn: MutableStateFlow<String?> = MutableStateFlow(null)

    private val _isLoading = MutableStateFlow(false)

    private val _taskAsync = testRepository.getMsg()
        .map { handleResult(it) }
        .onStart { emit(Async.Loading) }

    // StateFlow 和 shareFlow 的区别
    // StateFlow 是一个特殊的 shareFlow
    // 首先他们都是热流
    // 其次StateFlow只关心状态的变化，且支持解决背压问题
    val uiState: StateFlow<MainUiState> = combine(
        _submitBtn, _isLoading, _taskAsync
    ) { submitBtn, isLoading, taskAsync ->
        when(taskAsync){
            Async.Loading -> {
                MainUiState("", true)
            }
            is Async.Success -> {
                MainUiState(taskAsync.data, isLoading)
            }
        }
    }.stateIn(  // 这里可以把冷流  转换位热流  ps: 冷流一旦被订阅 就立马会产生数据   hot flow 则不关心是否被订阅
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = MainUiState("", isShowLoading = false)
    )

    private fun handleResult(tasksResult: String): Async<String?> =
        if (tasksResult.isEmpty()) {
            Async.Success("")
        } else {
            Async.Success(tasksResult)
        }


    fun saveMsg(value: String) {
        _isLoading.value = true
        viewModelScope.launch {
            testRepository.setMsg(value)
            _isLoading.value = false
        }
    }




}