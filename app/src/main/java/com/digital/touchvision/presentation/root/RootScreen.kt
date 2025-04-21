package com.digital.touchvision.presentation.root

import androidx.compose.runtime.Composable
import com.digital.touchvision.navigation.AppNavGraph
import com.digital.touchvision.navigation.Screen
import com.digital.touchvision.navigation.rememberNavigationState
import com.digital.touchvision.presentation.factory.VisionViewModelFactory
import com.digital.touchvision.presentation.home.HomeScreen
import com.digital.touchvision.presentation.home.HomeScreenState
import com.digital.touchvision.presentation.start.StartScreen

@Composable
fun RootScreen(
    viewModelFactory: VisionViewModelFactory,
    onButtonClickListener: (HomeScreenState) -> Unit
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
                viewModelFactory = viewModelFactory,
                onButtonClickListener = {
                    onButtonClickListener(it)
                }
            )
        }
    )
}