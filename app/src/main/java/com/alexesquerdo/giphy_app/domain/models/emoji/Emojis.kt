package com.alexesquerdo.giphy_app.domain.models.emoji

import com.alexesquerdo.giphy_app.domain.models.common.GiphyItem
import com.alexesquerdo.giphy_app.domain.models.common.Meta
import com.alexesquerdo.giphy_app.domain.models.common.Pagination

data class Emojis(
    val emojis: List<GiphyItem>,
    val meta: Meta,
    val pagination: Pagination
)
