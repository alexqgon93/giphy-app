package com.alexesquerdo.giphy_app.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.unit.dp
import com.alexesquerdo.giphy_app.R
import com.alexesquerdo.giphy_app.components.molecules.GifGridMolecule
import com.alexesquerdo.giphy_app.domain.models.GiphyItem
import com.alexesquerdo.giphy_app.feature.common.ErrorView
import com.alexesquerdo.giphy_app.feature.detailScreen.DetailScreenRoute
import com.alexesquerdo.giphy_app.feature.home.ScreenState.*

@Composable
fun HomeScreenRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    onClickItem: () -> Unit,
) {
    val state by viewModel.state.collectAsState()
    HomeScreen(state = state, viewModel = viewModel, onClickItem = onClickItem)
    LaunchedEffect(Unit) { viewModel.getTrending() }
}

@Composable
fun HomeScreen(
    state: HomeUiState,
    viewModel: HomeViewModel,
    onClickItem: () -> Unit,
) {
    when (state.screenState) {
        ERROR -> ErrorView()

        SUCCESS -> Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
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
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                )
            }
            state.gifItems?.let { items ->
                GifGridMolecule(
                    gifs = items,
                    onClickItem = { item ->
                        state.itemSelected = item
                        onClickItem()
                    }
                )
            }
        }

        LOADING -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
