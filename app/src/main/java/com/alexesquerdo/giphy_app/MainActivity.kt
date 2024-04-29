package com.alexesquerdo.giphy_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alexesquerdo.giphy_app.navigation.Navigation
import com.alexesquerdo.giphy_app.ui.theme.GiphyappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiphyappTheme(darkTheme = false) {
                Navigation()
            }
        }
    }
}