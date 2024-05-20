package com.alexesquerdo.giphy_app.network.responses.emoji


import com.alexesquerdo.giphy_app.network.responses.common.NetworkGiphyItem
import com.alexesquerdo.giphy_app.network.responses.common.NetworkMeta
import com.alexesquerdo.giphy_app.network.responses.common.NetworkPagination
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkEmojis(
    @Json(name = "data")
    val emojis: List<NetworkGiphyItem>,
    @Json(name = "meta")
    val meta: NetworkMeta,
    @Json(name = "pagination")
    val pagination: NetworkPagination
)