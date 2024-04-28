package com.alexesquerdo.giphy_app.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alexesquerdo.giphy_app.feature.home.HomeViewModel

@Composable
fun NavigationMainHost(viewModel: HomeViewModel, navController: NavHostController) {
    NavHost(navController = navController, startDestination = MAIN_GRAPH_ROUTE) {
        mainGraph(viewModel = viewModel, navController = navController)
    }
}