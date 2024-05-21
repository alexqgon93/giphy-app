package com.alexesquerdo.giphy_app.domain.models.categories

import com.alexesquerdo.giphy_app.domain.models.common.GiphyItem

data class Category(
    val gif: GiphyItem,
    val name: String,
    val nameEncoded: String,
    val subcategories: List<Subcategory>
)
