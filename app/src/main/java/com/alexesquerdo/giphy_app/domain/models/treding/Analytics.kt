package com.alexesquerdo.giphy_app.domain.models.treding

import com.alexesquerdo.giphy_app.domain.models.common.Url

data class Analytics(
    val onClick: Url,
    val onLoad: Url,
    val onSent: Url,
)