package com.alexesquerdo.giphy_app.components.atoms.shimmer

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexesquerdo.giphy_app.ui.theme.GiphyappTheme

@Composable
fun ShimmerCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(15.dp),
    ) { ShimmerAnimation() }
}

@Composable
private fun ShimmerAnimation(
    colors: List<Color> = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.9f)
    ),
    xShimmer: Float = 0f,
    yShimmer: Float = 0f,
    gradientWidth: Float = 200f,
    animationSpec: InfiniteRepeatableSpec<Float> = infiniteRepeatable(
        animation = tween(
            durationMillis = 1300,
            delayMillis = 300,
            easing = FastOutSlowInEasing
        ), repeatMode = RepeatMode.Restart
    ),
) {
    val transition = rememberInfiniteTransition(label = "")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = gradientWidth,
        animationSpec = animationSpec,
        label = ""
    )

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(
            xShimmer + translateAnim - gradientWidth,
            yShimmer + translateAnim - gradientWidth
        ), end = Offset(xShimmer + translateAnim, yShimmer + translateAnim)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = brush)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewShimmerCard() = GiphyappTheme { ShimmerCard() }