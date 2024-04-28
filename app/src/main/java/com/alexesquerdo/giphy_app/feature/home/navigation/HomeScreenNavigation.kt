package com.alexesquerdo.giphy_app.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alexesquerdo.giphy_app.feature.home.HomeScreenRoute
import com.alexesquerdo.giphy_app.feature.home.HomeViewModel

internal const val HOME_SCREEN_ROUTE = "home_screen_route"

fun NavGraphBuilder.homeScreenNavigation(
    viewModel: HomeViewModel,
    onClickItem: () -> Unit,
) {
    composable(route = HOME_SCREEN_ROUTE) {
        HomeScreenRoute(viewModel = viewModel, onClickItem = onClickItem)
    }
}