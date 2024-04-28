package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measures_entity")
data class MeasuresEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val height: String,
    val mp4: String?,
    val mp4Size: String?,
    val size: String,
    val url: String,
    val webp: String,
    val webpSize: String,
    val width: String
)