package com.alexesquerdo.giphy_app.feature.home

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.alexesquerdo.giphy_app.R
import com.alexesquerdo.giphy_app.components.atoms.ShimmerCard
import com.alexesquerdo.giphy_app.domain.models.GiphyItem
import com.alexesquerdo.giphy_app.feature.common.ErrorView
import com.alexesquerdo.giphy_app.feature.home.ScreenState.*

@Composable
fun HomeScreenRoute(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    HomeScreen(state = state, viewModel = viewModel, onClickItem = {})
    LaunchedEffect(Unit) { viewModel.getTrending() }
}

@Composable
fun HomeScreen(
    state: HomeUiState,
    viewModel: HomeViewModel,
    onClickItem: (GiphyItem) -> Unit,
) {
    var filledText by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        when (state.screenState) {
            ERROR -> ErrorView()

            SUCCESS -> Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 16.dp,
                            start = 24.dp,
                            end = 24.dp,
                            bottom = 16.dp
                        ),
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.inputText,
                        onValueChange = { input ->
                            filledText = input
                            viewModel.onChangeValue(input)
                        },
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Right
                        ),
                        label = { Text(text = stringResource(R.string.write_here_text_field)) },
                        placeholder = { Text(text = stringResource(R.string.placeholder_text_field)) },
                        enabled = true,
                        maxLines = 1,
                        minLines = 1,
                        singleLine = true
                    )
                }
                state.gifItems?.let { items ->
                    GifGrid(gifs = items, onClickItem = onClickItem)
                }
            }

            LOADING -> Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(modifier = Modifier.height(500.dp))
            }
        }
    }
}

@Composable
fun GifGrid(gifs: List<GiphyItem>, onClickItem: (GiphyItem) -> Unit) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(gifs.size) { item ->
            GifItem(gifItem = gifs[item], modifier = Modifier.clickable {
                onClickItem(gifs[item])
            })
        }
    }
}

@Composable
fun GifItem(gifItem: GiphyItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
    ) {
        SubcomposeAsyncImage(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(gifItem.images.fixedHeight.url)
                .decoderFactory(
                    if (SDK_INT >= 28) {
                        ImageDecoderDecoder.Factory()
                    } else {
                        GifDecoder.Factory()
                    }
                )
                .build(),
            loading = {
                ShimmerCard()
            },
            contentDescription = ""
        )
    }
}