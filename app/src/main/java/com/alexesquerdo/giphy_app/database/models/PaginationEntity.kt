package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pagination_entity")
data class PaginationEntity(
    @PrimaryKey(autoGenerate = false)
    val count: Int,
    val offset: Int,
    val totalCount: Int,
)