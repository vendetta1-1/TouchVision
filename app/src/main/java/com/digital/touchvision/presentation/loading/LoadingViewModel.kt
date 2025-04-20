package com.digital.touchvision.presentation.loading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadingViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<LoadingScreenState>(LoadingScreenState.Initial)
    val state = _state.asStateFlow()

    fun startLoading() {
        viewModelScope.launch {
            _state.emit(
                value = if (_state.value is LoadingScreenState.Initial) {
                    LoadingScreenState.Loading(0)
                } else if (_state.value is LoadingScreenState.Loading) {
                    delay(1_000)
                    LoadingScreenState.Loading((_state.value as LoadingScreenState.Loading).percent + 1)
                } else if (_state.value == LoadingScreenState.Loading(100)) {
                    delay(1_000)
                    LoadingScreenState.Ready
                } else {
                    LoadingScreenState.Ready
                }
            )
        }
    }
}