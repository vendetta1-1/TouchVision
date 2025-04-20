package com.digital.touchvision.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    startScreenContent: @Composable () -> Unit,
    homeScreenContent: @Composable () -> Unit,
    loadingScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Start.route
    ) {
        composable(Screen.Start.route) {
            startScreenContent()
        }

        composable(Screen.Home.route) {
            homeScreenContent()
        }

        composable(Screen.Loading.route) {
            loadingScreenContent()
        }
    }
}