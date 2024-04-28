package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_entity")
data class GiphyItemEntity(
    val altText: String,
    val analytics: AnalyticsEntity,
    val analyticsResponsePayload: String,
    val bitlyGiUrl: String,
    val bitlyUrl: String,
    val contentUrl: String,
    val embedUrl: String,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val images: ImagesEntity,
    val importDatetime: String,
    val isSticker: Int,
    val rating: String,
    val slug: String,
    val source: String,
    val sourcePostUrl: String,
    val sourceTld: String,
    val title: String,
    val trendingDatetime: String,
    val type: String,
    val url: String,
    val user: UserEntity?,
    val username: String,
)

