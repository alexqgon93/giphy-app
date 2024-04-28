package com.alexesquerdo.giphy_app.domain.models

data class Trending(
    val giphyItems: List<GiphyItem>,
    val meta: Meta,
    val pagination: Pagination
)