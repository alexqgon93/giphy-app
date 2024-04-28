package com.alexesquerdo.giphy_app.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.alexesquerdo.giphy_app.components.atoms.GifCardAtom
import com.alexesquerdo.giphy_app.domain.models.GiphyItem


@Composable
fun GifGridMolecule(gifs: LazyPagingItems<GiphyItem>, onClickItem: (GiphyItem) -> Unit) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(gifs.itemCount) { item ->
            gifs[item]?.let {
                GifCardAtom(gifItem = it, modifier = Modifier.clickable {
                    onClickItem(it)
                })
            }
        }
        item {
            if (gifs.loadState.append is LoadState.Loading) {
                CircularProgressIndicator()
            }
        }
    }
}