package com.alexesquerdo.giphy_app.components.atoms.cardAtom

import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import com.alexesquerdo.giphy_app.mocks.gifItemMock
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
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
    fun gifCardAtom_isDisplayed(): Unit = runBlocking {
        with(composeTestRule) {
            delay(3000)
            onNode(hasAnyChild(hasContentDescription("content description of ${gifItemMock.id}"))).assertExists()
        }
    }
}