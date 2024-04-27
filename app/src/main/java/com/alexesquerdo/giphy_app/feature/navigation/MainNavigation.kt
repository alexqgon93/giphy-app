package com.alexesquerdo.giphy_app.feature.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alexesquerdo.giphy_app.feature.home.HomeScreenRoute

internal const val MAIN_NAVIGATION_SCREEN_ROUTE = "home"

fun NavGraphBuilder.mainNavigation() {
    composable(route = MAIN_NAVIGATION_SCREEN_ROUTE) {
        HomeScreenRoute()
    }
}