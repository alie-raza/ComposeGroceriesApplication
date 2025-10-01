package com.alidev.groceriesapplication.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alidev.groceriesapplication.navigation.screen.BottomNavItemScreen
import com.alidev.groceriesapplication.navigation.screen.Screen
import com.alidev.groceriesapplication.presentation.screen.about.AboutScreen
import com.alidev.groceriesapplication.presentation.screen.cart.CartScreen
import com.alidev.groceriesapplication.presentation.screen.explore.ExploreScreen
import com.alidev.groceriesapplication.presentation.screen.home.HomeScreen
import com.alidev.groceriesapplication.utils.Constants.PRODUCT_ARGUMENT_KEY


@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomNavItemScreen.Home.route
    ) {
        composable(route = BottomNavItemScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomNavItemScreen.Explore.route) {
            ExploreScreen()
        }
        composable(route = BottomNavItemScreen.Cart.route) {
            CartScreen()
        }
        composable(route = BottomNavItemScreen.About.route) {
            AboutScreen()
        }

        searchNavGraph()

        detailsNavGraph()
    }
}

fun NavGraphBuilder.detailsNavGraph() {
    navigation(
        route = Graph.DETAILS,
        startDestination = Screen.Details.route
    ) {
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(PRODUCT_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
//            DetailScreen()
        }
    }
}

fun NavGraphBuilder.searchNavGraph() {
    navigation(
        route = Graph.SEARCH,
        startDestination = Screen.Search.route
    ) {
        composable(route = Screen.Search.route) {
//            SearchScreen()
        }
    }
}