package com.alexesquerdo.giphy_app.domain.models

data class Pagination(
    val count: Int,
    val offset: Int,
    val totalCount: Int
)