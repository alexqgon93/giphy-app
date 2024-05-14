package com.alexesquerdo.giphy_app.feature.main

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ShareCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.alexesquerdo.giphy_app.R
import com.alexesquerdo.giphy_app.components.molecules.header.HeaderMolecule
import com.alexesquerdo.giphy_app.components.molecules.header.HeaderMoleculeModel
import com.alexesquerdo.giphy_app.domain.models.GiphyItem
import com.alexesquerdo.giphy_app.feature.home.HomeViewModel
import com.alexesquerdo.giphy_app.navigation.main.NavigationMainHost

@Composable
fun MainScreenRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) = MainScreen(viewModel = viewModel)


@Composable
internal fun MainScreen(
    viewModel: HomeViewModel,
    screenState: MainScreenState = rememberMainScreenState(),
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            HeaderMolecule(
                model = HeaderMoleculeModel(
                    titleImage = R.drawable.ic_logo,
                    enableBackPressed = screenState.showUpNavigation,
                    onBackPressed = {
                        screenState.onUpClick()
                    },
                    element = if (screenState.showUpNavigation) state.itemSelected else null
                )
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationMainHost(
                    viewModel = viewModel,
                    navController = screenState.navController,
                )
            }
        },
        floatingActionButton = {
            if (screenState.showUpNavigation) {
                FloatingActionButton(onClick = {
                    state.itemSelected?.let {
                        shareGif(
                            context = context,
                            gitItem = it
                        )
                    }
                }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "Share Gif")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    )
}

private fun shareGif(context: Context, gitItem: GiphyItem) = ShareCompat
    .IntentBuilder(context)
    .setType("text/plain")
    .setSubject(gitItem.title)
    .setText(gitItem.url).intent.also(context::startActivity)