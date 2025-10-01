package com.alidev.groceriesapplication.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alidev.groceriesapplication.navigation.screen.Screen
import com.alidev.groceriesapplication.presentation.screen.OnBoardingScreen
import com.alidev.groceriesapplication.presentation.screen.SplashScreen
@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(navController = navController)
        }

        composable(route = Graph.MAIN) {
//            MainScreen()
        }
    }
}