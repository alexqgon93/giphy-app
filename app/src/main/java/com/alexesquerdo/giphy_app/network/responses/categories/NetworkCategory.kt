package com.alexesquerdo.giphy_app.network.responses.categories


import com.alexesquerdo.giphy_app.network.responses.common.NetworkGiphyItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCategory(
    @Json(name = "gif")
    val gif: NetworkGiphyItem,
    @Json(name = "name")
    val name: String,
    @Json(name = "name_encoded")
    val nameEncoded: String,
    @Json(name = "subcategories")
    val subcategories: List<NetworkSubcategory>
)