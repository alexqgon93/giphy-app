package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkPagination(
    @Json(name = "count")
    val count: Int,
    @Json(name = "offset")
    val offset: Int,
    @Json(name = "total_count")
    val totalCount: Int
)