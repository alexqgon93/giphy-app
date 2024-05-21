package com.alexesquerdo.giphy_app.components.molecules.header

import com.alexesquerdo.giphy_app.domain.models.common.GiphyItem

data class HeaderMoleculeModel(
    val titleImage: Int?,
    val enableBackPressed: Boolean = false,
    val onBackPressed: () -> Unit = {},
    val element: GiphyItem? = null
)