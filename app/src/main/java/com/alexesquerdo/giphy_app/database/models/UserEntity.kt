package com.alexesquerdo.giphy_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_entity")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val avatarUrl: String,
    val bannerImage: String,
    val bannerUrl: String,
    val description: String,
    val displayName: String,
    val instagramUrl: String,
    val isVerified: Boolean,
    val profileUrl: String,
    val username: String,
    val websiteUrl: String,
)