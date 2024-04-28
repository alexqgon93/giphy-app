package com.alexesquerdo.giphy_app.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alexesquerdo.giphy_app.feature.home.navigation.HOME_SCREEN_ROUTE

@Composable
fun rememberMainScreenState(
    navController: NavHostController = rememberNavController(),
): MainScreenState = remember { MainScreenState(navController) }


class MainScreenState(val navController: NavHostController) {
    private val currentRoute: String
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route
            ?: ""

    val showUpNavigation: Boolean
        @Composable get() = when (currentRoute) {
            HOME_SCREEN_ROUTE -> false
            else -> true
        }


    fun onUpClick() {
        navController.popBackStack()
    }
}