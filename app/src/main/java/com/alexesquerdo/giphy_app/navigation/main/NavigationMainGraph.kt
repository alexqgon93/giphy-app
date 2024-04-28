package com.alexesquerdo.giphy_app.navigation.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.alexesquerdo.giphy_app.feature.detailScreen.navigation.detailScreenNavigation
import com.alexesquerdo.giphy_app.feature.detailScreen.navigation.navigateToDetailScreen
import com.alexesquerdo.giphy_app.feature.home.HomeViewModel
import com.alexesquerdo.giphy_app.feature.home.navigation.HOME_SCREEN_ROUTE
import com.alexesquerdo.giphy_app.feature.home.navigation.homeScreenNavigation

const val MAIN_GRAPH_ROUTE = "main_graph_route"

fun NavGraphBuilder.mainGraph(
    navController: NavHostController,
    viewModel: HomeViewModel,
) {
    navigation(
        startDestination = HOME_SCREEN_ROUTE,
        route = MAIN_GRAPH_ROUTE,
    ) {
        homeScreenNavigation(
            viewModel = viewModel,
            onClickItem = navController::navigateToDetailScreen
        )
        detailScreenNavigation(viewModel)
    }
}