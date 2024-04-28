package com.alexesquerdo.giphy_app.feature.home

import com.alexesquerdo.giphy_app.domain.usecases.UseCaseTrending
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.alexesquerdo.giphy_app.data.mappers.toGiphyItem
import com.alexesquerdo.giphy_app.database.models.GiphyItemEntity
import com.alexesquerdo.giphy_app.domain.models.GiphyItem
import com.alexesquerdo.giphy_app.domain.models.Trending
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCaseTrending: UseCaseTrending,
    pager: Pager<Int, GiphyItemEntity>,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    private lateinit var listGiphyItemEntity: List<GiphyItemEntity>

    /*fun getTrending() = viewModelScope.launch {
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
    }*/

    val filterText = MutableStateFlow("")

    private val gifPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toGiphyItem() }
        }
        .cachedIn(viewModelScope)

    val filteredGifPagingFlow = combine(
        this.gifPagingFlow,
        filterText
    ) { pagingData, filter ->
        pagingData.filter { it.title.contains(filter, ignoreCase = true) }
    }.cachedIn(viewModelScope)

    fun onChangeValue(input: String) {
        filterText.value = input
        _state.update { uiState ->
            uiState.copy(inputText = input)
        }
        /*_state.update { uiState ->
            uiState.copy(inputText = input,
                gifItems = trending.giphyItems.filter {
                    it.title.contains(
                        input,
                        ignoreCase = true
                    )
                }
            )
        }*/
    }
}