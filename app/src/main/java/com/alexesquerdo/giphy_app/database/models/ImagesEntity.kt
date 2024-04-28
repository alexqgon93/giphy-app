package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alexesquerdo.giphy_app.domain.models.Images

@Entity(tableName = "images_entity")
data class ImagesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fixedHeight: MeasuresEntity,
    val fixedHeightDownSampled: MeasuresEntity,
    val fixedHeightSmall: MeasuresEntity,
    val fixedWidth: MeasuresEntity,
    val fixedWidthDownSampled: MeasuresEntity,
    val fixedWidthSmall: MeasuresEntity,
    val original: OriginalEntity,
)

fun Images.toDatabase() = ImagesEntity(
    fixedHeight = fixedHeight.toDatabase(),
    fixedHeightDownSampled = fixedHeightDownSampled.toDatabase(),
    fixedHeightSmall = fixedHeightSmall.toDatabase(),
    fixedWidth = fixedWidth.toDatabase(),
    fixedWidthDownSampled = fixedWidthDownSampled.toDatabase(),
    fixedWidthSmall = fixedWidthSmall.toDatabase(),
    original = original.toDatabase(),
)
