package com.alexesquerdo.giphy_app.feature.home

import com.alexesquerdo.giphy_app.domain.models.GiphyItem

data class HomeUiState(
    val screenState: ScreenState = ScreenState.LOADING,
    val gifItems: List<GiphyItem>? = null,
    val inputText: String = "",
)


enum class ScreenState { LOADING, SUCCESS, ERROR }
