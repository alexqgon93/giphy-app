package com.alexesquerdo.giphy_app.domain.models

data class User(
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