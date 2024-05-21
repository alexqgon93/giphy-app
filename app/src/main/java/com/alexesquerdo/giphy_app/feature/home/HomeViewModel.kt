package com.alexesquerdo.giphy_app.feature.home

import com.alexesquerdo.giphy_app.domain.usecases.UseCaseTrending
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexesquerdo.giphy_app.domain.models.treding.Trending
import com.alexesquerdo.giphy_app.domain.usecases.UseCaseCategories
import com.alexesquerdo.giphy_app.domain.usecases.UseCaseEmojis
import com.alexesquerdo.giphy_app.ui.utils.filterGiphyItemsByTitle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCaseTrending: UseCaseTrending,
    private val useCaseEmojis: UseCaseEmojis,
    private val useCaseCategories: UseCaseCategories
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    private lateinit var trending: Trending

    fun getTrending() = viewModelScope.launch {
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

    fun getEmojis() = viewModelScope.launch {
        useCaseEmojis.invoke().fold(
            ifLeft = {
                _state.update { it.copy(screenState = ScreenState.ERROR) }
            },
            ifRight = { emojis ->
                _state.update { it.copy(emojis = emojis) }
            }
        )
    }

    fun getCategories() = viewModelScope.launch {
        useCaseCategories.invoke().fold(
            ifLeft = {
                _state.update { it.copy(screenState = ScreenState.ERROR) }
            },
            ifRight = { categories ->
                _state.update { it.copy(categories = categories) }
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