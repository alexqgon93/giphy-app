package com.alexesquerdo.giphy_app.components.molecules.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexesquerdo.giphy_app.R
import com.alexesquerdo.giphy_app.ui.theme.GiphyappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HeaderMolecule(model: HeaderMoleculeModel) = with(model) {
    var showDropDown by remember { mutableStateOf(false) }
    val uriHandler = LocalUriHandler.current
    TopAppBar(
        title = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                if (titleImage != null) {
                    Image(
                        modifier = Modifier.height(32.dp),
                        painter = painterResource(id = titleImage),
                        contentDescription = stringResource(R.string.logo_giphy),
                        alignment = Alignment.Center
                    )
                }
            }
        },
        navigationIcon = {
            if (enableBackPressed) {
                IconButton(onClick = model.onBackPressed, modifier = Modifier.size(32.dp)) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back),
                        tint = Color.Black,
                        contentDescription = stringResource(R.string.back_content_desciption)
                    )
                }
            } else Spacer(modifier = Modifier.size(32.dp))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
        ),
        modifier = Modifier
            .background(color = Color.White)
            .padding(start = 10.dp, end = 10.dp),
        actions = {
            element?.let {
                IconButton(
                    onClick = { showDropDown = !showDropDown },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                }
                DropdownMenu(expanded = showDropDown, onDismissRequest = { showDropDown = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Url") },
                        onClick = { uriHandler.openUri(element.url) })
                }
            } ?: run { Spacer(modifier = Modifier.size(32.dp)) }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HeaderMoleculePreview() {
    GiphyappTheme {
        HeaderMolecule(
            model = HeaderMoleculeModel(
                titleImage = R.drawable.ic_logo,
                enableBackPressed = true,
                onBackPressed = {}
            )
        )
    }
}
