package com.alexesquerdo.giphy_app.network.responses.trending


import com.alexesquerdo.giphy_app.network.responses.common.NetworkGiphyItem
import com.alexesquerdo.giphy_app.network.responses.common.NetworkMeta
import com.alexesquerdo.giphy_app.network.responses.common.NetworkPagination
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkTrending(
    @Json(name = "data")
    val giphyItem: List<NetworkGiphyItem>,
    @Json(name = "meta")
    val meta: NetworkMeta,
    @Json(name = "pagination")
    val pagination: NetworkPagination
)