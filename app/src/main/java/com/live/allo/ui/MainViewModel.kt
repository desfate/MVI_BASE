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
    val submitText: String = ""
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
        .map { Async.Success(it) }
        .onStart { emit(Async.Success("")) }

    val uiState: StateFlow<MainUiState> = combine(
        _submitBtn, _isLoading, _taskAsync
    ) { submitBtn, isLoading, taskAsync ->
        MainUiState(taskAsync.data)
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = MainUiState("")
    )


    fun saveMsg(value: String) {
        viewModelScope.launch {
            testRepository.setMsg(value)
        }
    }




}