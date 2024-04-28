package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "analytics_entity")
data class AnalyticsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val onClick: UrlEntity,
    val onLoad: UrlEntity,
    val onSent: UrlEntity,
)
