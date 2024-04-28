package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "url_entity")
data class UrlEntity(
    @PrimaryKey(autoGenerate = true)
    val url: String,
)