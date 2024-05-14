package com.alexesquerdo.giphy_app.feature.main

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.app.ShareCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.alexesquerdo.giphy_app.R
import com.alexesquerdo.giphy_app.components.molecules.appBarIcon.AppBarIconModel
import com.alexesquerdo.giphy_app.components.molecules.appBarIcon.AppBarIconMolecule
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
                state.itemSelected?.let {
                    FloatingActionButton(onClick = { shareGif(context = context, gitItem = it) }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = stringResource(R.string.share_gif_content_description)
                        )
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.EndOverlay,
        bottomBar = {
            BottomAppBar {
                AppBarIconMolecule(
                    model = AppBarIconModel(
                        Icons.Outlined.Home,
                        onClick = {},
                        contentDescription = stringResource(R.string.home_content_description)
                    )
                )
                if (!screenState.showUpNavigation) Spacer(modifier = Modifier.weight(1f))
                AppBarIconMolecule(
                    model = AppBarIconModel(
                        Icons.Sharp.Favorite,
                        onClick = {},
                        contentDescription = stringResource(R.string.favorite_content_description)
                    )
                )
                if (!screenState.showUpNavigation) Spacer(modifier = Modifier.weight(1f))
                AppBarIconMolecule(
                    model = AppBarIconModel(
                        Icons.Outlined.AccountCircle,
                        onClick = {},
                        contentDescription = stringResource(R.string.account_circle_content_description)
                    )
                )
                if (!screenState.showUpNavigation) Spacer(modifier = Modifier.weight(1f))
                AppBarIconMolecule(
                    model = AppBarIconModel(
                        Icons.Outlined.Settings,
                        onClick = {},
                        contentDescription = stringResource(R.string.settings_content_description)
                    )
                )
            }
        }
    )
}

private fun shareGif(context: Context, gitItem: GiphyItem) = ShareCompat
    .IntentBuilder(context)
    .setType("text/plain")
    .setSubject(gitItem.title)
    .setText(gitItem.url).intent.also(context::startActivity)