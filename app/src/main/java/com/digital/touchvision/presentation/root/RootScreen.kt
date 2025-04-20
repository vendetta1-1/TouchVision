package com.digital.touchvision.presentation.root

import androidx.compose.runtime.Composable
import com.digital.touchvision.navigation.AppNavGraph
import com.digital.touchvision.navigation.Screen
import com.digital.touchvision.navigation.rememberNavigationState
import com.digital.touchvision.presentation.factory.VisionViewModelFactory
import com.digital.touchvision.presentation.home.HomeScreen
import com.digital.touchvision.presentation.loading.LoadingScreen
import com.digital.touchvision.presentation.start.StartScreen

@Composable
fun RootScreen(
    viewModelFactory: VisionViewModelFactory
) {
    val navigationState = rememberNavigationState()

    AppNavGraph(
        navHostController = navigationState.navHostController,
        startScreenContent = {
            StartScreen()
            navigationState.navigateTo(Screen.Home.route)
        },
        homeScreenContent = {
            HomeScreen(
                onSettingsClickListener = { navigationState.navigateTo(Screen.Settings.route) },
                viewModelFactory = viewModelFactory
            )
        },
        loadingScreenContent = {
            LoadingScreen(
                viewModelFactory = viewModelFactory
            )
        }
    )
}