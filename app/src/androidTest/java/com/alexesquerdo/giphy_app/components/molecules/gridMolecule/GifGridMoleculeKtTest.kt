package com.alexesquerdo.giphy_app.components.molecules.gridMolecule

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import com.alexesquerdo.giphy_app.mocks.gifItemMock
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
                gifs = listOf(gifItemMock),
                onClickItem = {}
            )
        }
    }

    @Test
    fun gifGridMoleculeIsDisplayed(): Unit = with(composeTestRule) {
        onNode(hasContentDescription("content description of ${gifItemMock.id}")).assertExists()
    }
}