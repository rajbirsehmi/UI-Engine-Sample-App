package com.creative.uienginesampleapp.action_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.focusable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IconButtonShowcase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .testTag("icon_button_standard")
                    .focusable()
            ) {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite")
            }
            FilledIconButton(
                onClick = { },
                modifier = Modifier
                    .testTag("icon_button_filled")
                    .focusable()
            ) {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite")
            }
            FilledTonalIconButton(
                onClick = { },
                modifier = Modifier
                    .testTag("icon_button_tonal")
                    .focusable()
            ) {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite")
            }
            OutlinedIconButton(
                onClick = { },
                modifier = Modifier
                    .testTag("icon_button_outlined")
                    .focusable()
            ) {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite")
            }
        }

        var checked by remember { mutableStateOf(false) }
        IconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
            modifier = Modifier
                .testTag("icon_button_toggle")
                .focusable()
        ) {
            Icon(
                imageVector = if (checked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Toggle Favorite"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IconButtonShowcasePreview() {
    IconButtonShowcase()
}
