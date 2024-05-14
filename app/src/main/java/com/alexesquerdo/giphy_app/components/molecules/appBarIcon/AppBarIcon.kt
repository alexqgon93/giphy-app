package com.alexesquerdo.giphy_app.components.molecules.appBarIcon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexesquerdo.giphy_app.ui.theme.GiphyappTheme

@Composable
fun AppBarIconMolecule(model: AppBarIconModel) = with(model) {
    IconButton(onClick = onClick) {
        Icon(imageVector = imageVector, contentDescription = contentDescription)
    }
}

@Composable
@Preview
fun AppBarIconMoleculePreview() = GiphyappTheme {
    AppBarIconMolecule(
        model = AppBarIconModel(
            imageVector = Icons.Default.Share,
            onClick = {},
            contentDescription = "Context Description"
        )
    )
}