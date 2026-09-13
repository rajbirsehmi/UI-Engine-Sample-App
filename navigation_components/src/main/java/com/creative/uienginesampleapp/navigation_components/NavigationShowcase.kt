package com.creative.uienginesampleapp.navigation_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NavigationShowcase() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home" to Icons.Default.Home, "Profile" to Icons.Default.Person, "Settings" to Icons.Default.Settings)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("navigation_bar")
        ) {
            items.forEachIndexed { index, (label, icon) ->
                NavigationBarItem(
                    icon = { Icon(icon, contentDescription = label) },
                    label = { Text(label) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    modifier = Modifier.testTag("nav_item_$index")
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationShowcasePreview() {
    NavigationShowcase()
}
