package com.alexesquerdo.giphy_app.components.atoms.cardAtom

import android.os.Build
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.alexesquerdo.giphy_app.R
import com.alexesquerdo.giphy_app.components.atoms.shimmer.ShimmerCard
import com.alexesquerdo.giphy_app.domain.models.GiphyItem

@Composable
fun GifCardAtom(gifItem: GiphyItem, modifier: Modifier = Modifier) = Card(
    modifier = modifier.fillMaxWidth(),
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
                if (Build.VERSION.SDK_INT >= 28) {
                    ImageDecoderDecoder.Factory()
                } else {
                    GifDecoder.Factory()
                }
            )
            .build(),
        loading = {
            ShimmerCard()
        },
        error = {
            ShimmerCard()
        },
        contentDescription = stringResource(R.string.content_description_gif_card_atom, gifItem.id)
    )
}