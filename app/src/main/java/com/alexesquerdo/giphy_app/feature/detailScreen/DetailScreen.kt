package com.alexesquerdo.giphy_app.feature.detailScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.alexesquerdo.giphy_app.feature.home.HomeUiState
import com.alexesquerdo.giphy_app.feature.home.HomeViewModel

@Composable
fun DetailScreenRoute(viewModel: HomeViewModel) {
    val state by viewModel.state.collectAsState()
    DetailScreen(state = state)
}

@Composable
fun DetailScreen(state: HomeUiState) {
}