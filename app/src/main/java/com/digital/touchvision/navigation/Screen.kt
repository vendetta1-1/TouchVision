package com.digital.touchvision.navigation

sealed class Screen(val route: String) {

    data object Start : Screen(START_ROUTE)

    data object Home : Screen(HOME_ROUTE)

    private companion object {
        const val START_ROUTE = "start"
        const val HOME_ROUTE = "home"
    }
}