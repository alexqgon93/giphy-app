package com.alexesquerdo.giphy_app.components.molecules.header

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import com.alexesquerdo.giphy_app.R
import org.junit.Before

import org.junit.Rule
import org.junit.Test

class HeaderMoleculeKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            HeaderMolecule(
                model = HeaderMoleculeModel(
                    titleImage = R.drawable.ic_logo,
                    enableBackPressed = true,
                    onBackPressed = {}
                )
            )
        }
    }

    @Test
    fun headerMoleculeIconIsDisplayed(): Unit = with(composeTestRule) {
        onNode(hasContentDescription("logo giphy")).assertExists()
    }

    @Test
    fun headerMoleculeBackIconIsDisplayed(): Unit = with(composeTestRule) {
        onNode(hasContentDescription("Back")).assertExists()
    }
}