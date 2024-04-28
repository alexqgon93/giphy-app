package com.alexesquerdo.giphy_app.domain.models

import com.alexesquerdo.giphy_app.domain.common.Measures

data class Images(
    val fixedHeight: Measures,
    val fixedHeightDownSampled: Measures,
    val fixedHeightSmall: Measures,
    val fixedWidth: Measures,
    val fixedWidthDownSampled: Measures,
    val fixedWidthSmall: Measures,
    val original: Original
)