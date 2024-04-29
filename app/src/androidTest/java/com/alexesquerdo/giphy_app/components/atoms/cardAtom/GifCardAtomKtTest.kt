package com.alexesquerdo.giphy_app.components.atoms.cardAtom

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.alexesquerdo.giphy_app.mocks.gifItemMock
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GifCardAtomKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            GifCardAtom(gifItem = gifItemMock)
        }
    }

    @Test
    fun gifCardAtom_isDisplayed(): Unit = with(composeTestRule) {
        onNodeWithContentDescription("content description of ${gifItemMock.id}").assertExists()
    }
}