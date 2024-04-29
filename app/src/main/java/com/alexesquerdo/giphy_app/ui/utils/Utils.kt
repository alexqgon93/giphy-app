package com.alexesquerdo.giphy_app.ui.utils

import com.alexesquerdo.giphy_app.domain.models.GiphyItem

fun filterGiphyItemsByTitle(
    giphyItems: List<GiphyItem>,
    input: String,
): List<GiphyItem> = giphyItems.filter { it.title.contains(input, ignoreCase = true) }