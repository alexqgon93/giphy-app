package com.alexesquerdo.giphy_app.ui.utils

import com.alexesquerdo.giphy_app.mocks.gifItemLeo
import com.alexesquerdo.giphy_app.mocks.gifItemPiscis
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class UtilsKtTest {

    companion object {
        private const val LEO = "leo"
        private const val ARIES = "aries"
        private const val TORTOR = "tortor"
    }

    @Test
    fun `filter giphy Items By Title then filters correctly`() {
        val result = filterGiphyItemsByTitle(listOf(gifItemLeo, gifItemPiscis), LEO)
        Assertions.assertEquals(1, result.size)
        Assertions.assertEquals(TORTOR, result[0].id)
    }

    @Test
    fun `filter giphy Items By Title but it doesn't match`() = Assertions.assertTrue(
        filterGiphyItemsByTitle(
            listOf(gifItemLeo, gifItemPiscis),
            ARIES
        ).isEmpty()
    )


    @Test
    fun `filter Giphy Items By title of an empty list returns empty list`() =
        Assertions.assertTrue(filterGiphyItemsByTitle(emptyList(), LEO).isEmpty())

}