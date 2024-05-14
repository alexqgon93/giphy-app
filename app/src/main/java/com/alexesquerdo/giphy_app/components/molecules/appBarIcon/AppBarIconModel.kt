package com.alexesquerdo.giphy_app.components.molecules.appBarIcon

import androidx.compose.ui.graphics.vector.ImageVector

data class AppBarIconModel(
    val imageVector: ImageVector,
    val onClick: () -> Unit,
    val contentDescription: String? = null
)
