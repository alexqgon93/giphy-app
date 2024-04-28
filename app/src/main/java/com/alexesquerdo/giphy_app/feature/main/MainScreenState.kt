package com.alexesquerdo.giphy_app.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberMainScreenState(
    navController: NavHostController = rememberNavController(),
): MainScreenState = remember { MainScreenState(navController) }


class MainScreenState(val navController: NavHostController) {
    val titleHeader: String
        @Composable get() = when (navController.currentBackStackEntry?.destination?.route) {
            "home" -> "Home"
            else -> "Other"
        }
}