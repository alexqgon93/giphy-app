package com.alexesquerdo.giphy_app.domain.models.treding

import com.alexesquerdo.giphy_app.domain.models.common.Measures
import com.alexesquerdo.giphy_app.domain.models.common.Original

data class Images(
    val fixedHeight: Measures,
    val fixedHeightDownSampled: Measures,
    val fixedHeightSmall: Measures,
    val fixedWidth: Measures,
    val fixedWidthDownSampled: Measures,
    val fixedWidthSmall: Measures,
    val original: Original
)