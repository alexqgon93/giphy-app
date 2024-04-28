package com.alexesquerdo.giphy_app.feature.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.alexesquerdo.giphy_app.feature.home.HomeViewModel
import com.alexesquerdo.giphy_app.feature.home.ScreenState
import com.alexesquerdo.giphy_app.navigation.main.NavigationMainHost

@Composable
fun MainScreenRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) = MainScreen(viewModel = viewModel)


@Composable
internal fun MainScreen(
    viewModel: HomeViewModel,
    screenState: MainScreenState = rememberMainScreenState(),
) {
    Scaffold(
        topBar = {
            // using the screen state we will set the header
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationMainHost(
                    viewModel = viewModel,
                    navController = screenState.navController
                )
            }
        },
    )
}