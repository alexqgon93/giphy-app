package com.alexesquerdo.giphy_app.feature.detailScreen

import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.alexesquerdo.giphy_app.feature.home.HomeUiState
import com.alexesquerdo.giphy_app.feature.home.HomeViewModel

@Composable
fun DetailScreenRoute(viewModel: HomeViewModel) {
    val state by viewModel.state.collectAsState()
    DetailScreen(state = state)
}

@Composable
fun DetailScreen(state: HomeUiState) {
    state.itemSelected?.let { gifItem ->
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Title: ${gifItem.title}",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "URL: ${gifItem.url}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Username: ${gifItem.user?.username}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Rating: ${gifItem.rating}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Import Date: ${gifItem.importDatetime}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Trending Date: ${gifItem.trendingDatetime}",
                style = MaterialTheme.typography.bodyLarge
            )

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(gifItem.images.fixedHeight.url)
                    .decoderFactory(
                        if (Build.VERSION.SDK_INT >= 28) {
                            ImageDecoderDecoder.Factory()
                        } else {
                            GifDecoder.Factory()
                        }
                    )
                    .build(),
                contentDescription = "Gif Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}
