package com.digital.touchvision.presentation.home

sealed class HomeScreenState {

    data object Initial : HomeScreenState()

    data object Start : HomeScreenState()

    data object End : HomeScreenState()
}