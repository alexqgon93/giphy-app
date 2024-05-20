package com.alexesquerdo.giphy_app.domain.models.common

data class Pagination(
    val count: Int,
    val offset: Int,
    val totalCount: Int?,
    val nextCursor: Int?
)