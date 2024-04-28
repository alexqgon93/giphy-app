package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trending_entity")
data class TrendingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val giphyItems: List<GiphyItemEntity>,
    val meta: MetaEntity,
    val pagination: PaginationEntity,
)