package com.alexesquerdo.giphy_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.alexesquerdo.giphy_app.feature.navigation.MAIN_NAVIGATION_SCREEN_ROUTE
import com.alexesquerdo.giphy_app.feature.navigation.mainNavigation

@Composable
internal fun RootHost() {
    val rootController = rememberNavController()
    NavHost(
        navController = rootController,
        startDestination = MAIN_NAVIGATION_SCREEN_ROUTE
    ) {
        mainNavigation()
    }
}