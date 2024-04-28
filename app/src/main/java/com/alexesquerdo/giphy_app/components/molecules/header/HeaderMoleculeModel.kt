package com.alexesquerdo.giphy_app.components.molecules.header

data class HeaderMoleculeModel(
    val titleImage: Int?,
    val enableBackPressed: Boolean = false,
    val onBackPressed: () -> Unit = {},
)