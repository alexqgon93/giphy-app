package com.alexesquerdo.giphy_app.components.molecules.gridMolecule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexesquerdo.giphy_app.components.atoms.cardAtom.GifCardAtom
import com.alexesquerdo.giphy_app.domain.models.common.GiphyItem


@Composable
fun GifGridMolecule(gifs: List<GiphyItem>, onClickItem: (GiphyItem) -> Unit) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(gifs.size) { item ->
            GifCardAtom(gifItem = gifs[item], modifier = Modifier.clickable {
                onClickItem(gifs[item])
            })
        }
    }
}