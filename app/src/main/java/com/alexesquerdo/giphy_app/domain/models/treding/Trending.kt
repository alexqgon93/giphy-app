package com.alexesquerdo.giphy_app.domain.models.treding

import com.alexesquerdo.giphy_app.domain.models.common.GiphyItem
import com.alexesquerdo.giphy_app.domain.models.common.Meta
import com.alexesquerdo.giphy_app.domain.models.common.Pagination

data class Trending(
    val giphyItems: List<GiphyItem>,
    val meta: Meta,
    val pagination: Pagination
)