package com.alexesquerdo.giphy_app.domain.models.categories

import com.alexesquerdo.giphy_app.domain.models.common.Meta
import com.alexesquerdo.giphy_app.domain.models.common.Pagination

data class Categories(
    val categories: List<Category>,
    val meta: Meta,
    val pagination: Pagination

)
