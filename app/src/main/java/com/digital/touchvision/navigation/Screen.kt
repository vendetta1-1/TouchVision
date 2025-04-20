package com.digital.touchvision.navigation

sealed class Screen(val route: String) {

    data object Start : Screen(START_ROUTE)

    data object Home : Screen(HOME_ROUTE)

    data object Loading : Screen(LOADING_ROUTE)

    data object Settings : Screen(SETTINGS_ROUTE)

    private companion object {
        const val START_ROUTE = "start"
        const val HOME_ROUTE = "home"
        const val LOADING_ROUTE = "loading"
        const val SETTINGS_ROUTE = "settings"
    }
}