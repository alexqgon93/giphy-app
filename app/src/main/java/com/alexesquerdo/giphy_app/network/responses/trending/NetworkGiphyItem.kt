package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkGiphyItem(
    @Json(name = "alt_text")
    val altText: String,
    @Json(name = "analytics")
    val analytics: NetworkAnalytics,
    @Json(name = "analytics_response_payload")
    val analyticsResponsePayload: String,
    @Json(name = "bitly_gif_url")
    val bitlyGifUrl: String,
    @Json(name = "bitly_url")
    val bitlyUrl: String,
    @Json(name = "content_url")
    val contentUrl: String,
    @Json(name = "embed_url")
    val embedUrl: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "images")
    val images: NetworkImages,
    @Json(name = "import_datetime")
    val importDatetime: String,
    @Json(name = "is_sticker")
    val isSticker: Int,
    @Json(name = "rating")
    val rating: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "source")
    val source: String,
    @Json(name = "source_post_url")
    val sourcePostUrl: String,
    @Json(name = "source_tld")
    val sourceTld: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "trending_datetime")
    val trendingDatetime: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "user")
    val user: NetworkUser?,
    @Json(name = "username")
    val username: String
)