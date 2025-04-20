package com.digital.touchvision.presentation.loading

sealed class LoadingScreenState {

    data object Initial : LoadingScreenState()

    data class Loading(val percent: Int) : LoadingScreenState()

    data object Ready : LoadingScreenState()
}