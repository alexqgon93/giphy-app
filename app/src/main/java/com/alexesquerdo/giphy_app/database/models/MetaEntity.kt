package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meta_entity")
data class MetaEntity(
    val msg: String,
    @PrimaryKey(autoGenerate = false)
    val responseId: String,
    val status: Int,
)