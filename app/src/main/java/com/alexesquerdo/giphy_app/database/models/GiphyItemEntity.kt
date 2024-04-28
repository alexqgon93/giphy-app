package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alexesquerdo.giphy_app.domain.models.Analytics
import com.alexesquerdo.giphy_app.domain.models.Images
import com.alexesquerdo.giphy_app.domain.models.User

@Entity(tableName = "gifentity")
data class GiphyItemEntity(
    @PrimaryKey(autoGenerate = true)
    val idGif: Int = 0,
    val altText: String,
    val analytics: Analytics,
    val analyticsResponsePayload: String,
    val bitlyGiUrl: String,
    val bitlyUrl: String,
    val contentUrl: String,
    val embedUrl: String,
    val id: String,
    val images: Images,
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
    val user: User?,
    val username: String,
)

