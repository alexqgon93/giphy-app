package com.alexesquerdo.giphy_app.feature.home

import com.alexesquerdo.giphy_app.domain.models.categories.Categories
import com.alexesquerdo.giphy_app.domain.models.common.GiphyItem
import com.alexesquerdo.giphy_app.domain.models.emoji.Emojis

data class HomeUiState(
    val screenState: ScreenState = ScreenState.LOADING,
    val gifItems: List<GiphyItem>? = null,
    val inputText: String = "",
    var itemSelected: GiphyItem? = null,
    val categories: Categories? = null,
    val emojis: Emojis? = null,
)


enum class ScreenState { LOADING, SUCCESS, ERROR }
