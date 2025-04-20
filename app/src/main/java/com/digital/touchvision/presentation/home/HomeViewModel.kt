package com.digital.touchvision.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<HomeScreenState>(HomeScreenState.Initial)
    val state = _state.asStateFlow()

    fun startService() {
        viewModelScope.launch {
            _state.emit(HomeScreenState.Start)
        }
    }

    fun stopService() {
        viewModelScope.launch {
            _state.emit(HomeScreenState.End)
        }
    }
}