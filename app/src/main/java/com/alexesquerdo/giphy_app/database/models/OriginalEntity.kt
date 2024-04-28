package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "original_entity")
data class OriginalEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val frames: String,
    val hash: String,
    val height: String,
    val mp4: String,
    val mp4Size: String,
    val size: String,
    val url: String,
    val webp: String,
    val webpSize: String,
    val width: String,
)