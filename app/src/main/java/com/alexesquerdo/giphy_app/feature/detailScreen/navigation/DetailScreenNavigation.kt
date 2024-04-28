package com.alexesquerdo.giphy_app.feature.detailScreen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.alexesquerdo.giphy_app.feature.detailScreen.DetailScreenRoute
import com.alexesquerdo.giphy_app.feature.home.HomeViewModel

internal const val DETAIL_SCREEN_ROUTE = "detail_screen_route"

fun NavController.navigateToDetailScreen(navOptions: NavOptions? = null) {
    navigate(DETAIL_SCREEN_ROUTE, navOptions)
}

fun NavGraphBuilder.detailScreenNavigation(
    viewModel: HomeViewModel,
) {
    composable(route = DETAIL_SCREEN_ROUTE) {
        DetailScreenRoute(viewModel = viewModel)
    }
}