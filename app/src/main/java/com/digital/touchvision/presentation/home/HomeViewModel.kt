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

    fun startOrStop() {
        viewModelScope.launch {
            _state.emit(
                value = if (state.value is HomeScreenState.Initial) HomeScreenState.Start else HomeScreenState.End
            )
        }
    }
}