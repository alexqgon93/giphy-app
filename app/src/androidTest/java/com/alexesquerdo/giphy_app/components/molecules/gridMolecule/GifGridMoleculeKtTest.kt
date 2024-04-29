package com.alexesquerdo.giphy_app.components.molecules.gridMolecule

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import com.alexesquerdo.giphy_app.mocks.gifItemMock
import com.alexesquerdo.giphy_app.mocks.gifItemMock2
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GifGridMoleculeKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            GifGridMolecule(
                gifs = listOf(gifItemMock, gifItemMock2),
                onClickItem = {}
            )
        }
    }

    @Test
    fun gifGridMoleculeElementIsDisplayed(): Unit = runBlocking {
        with(composeTestRule) {
            delay(3000)
            onNode(hasContentDescription("content description of ${gifItemMock.id}")).assertExists()
            onNode(hasContentDescription("content description of ${gifItemMock2.id}")).assertExists()
        }
    }
}