package com.alexesquerdo.giphy_app.feature.home

import com.alexesquerdo.giphy_app.domain.usecases.UseCaseTrending
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexesquerdo.giphy_app.domain.models.Trending
import com.alexesquerdo.giphy_app.ui.utils.filterGiphyItemsByTitle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCaseTrending: UseCaseTrending,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    private lateinit var trending: Trending

    fun getTrending() = viewModelScope.launch {
        delay(3000)
        useCaseTrending.invoke().fold(
            ifLeft = {
                _state.update { it.copy(screenState = ScreenState.ERROR) }
            },
            ifRight = { trending ->
                this@HomeViewModel.trending = trending
                _state.update {
                    it.copy(
                        screenState = ScreenState.SUCCESS,
                        gifItems = trending.giphyItems
                    )
                }
            }
        )
    }

    fun onChangeValue(input: String) {
        _state.update { uiState ->
            uiState.copy(
                inputText = input,
                gifItems = filterGiphyItemsByTitle(
                    giphyItems = trending.giphyItems,
                    input = input
                )
            )
        }
    }
}