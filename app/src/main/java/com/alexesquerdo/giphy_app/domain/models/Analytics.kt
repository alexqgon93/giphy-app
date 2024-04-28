package com.alexesquerdo.giphy_app.domain.models

import com.alexesquerdo.giphy_app.domain.common.Url

data class Analytics(
    val onClick: Url,
    val onLoad: Url,
    val onSent: Url,
)