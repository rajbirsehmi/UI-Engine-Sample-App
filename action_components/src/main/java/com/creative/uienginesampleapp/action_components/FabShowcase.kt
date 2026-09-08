package com.creative.uienginesampleapp.action_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.focusable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Text
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
fun FabShowcase() {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FloatingActionButton(
            onClick = { },
            modifier = Modifier
                .testTag("fab_standard")
                .focusable()
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
        
        LargeFloatingActionButton(
            onClick = { },
            modifier = Modifier
                .testTag("fab_large")
                .focusable()
        ) {
            Icon(Icons.Default.Favorite, contentDescription = "Favorite")
        }

        ExtendedFloatingActionButton(
            onClick = { },
            icon = { Icon(Icons.Default.Edit, contentDescription = null) },
            text = { Text("Edit Content") },
            modifier = Modifier
                .testTag("fab_extended")
                .focusable()
        )

        // Simple FAB Menu implementation
        Column(horizontalAlignment = Alignment.End) {
            if (expanded) {
                FloatingActionButton(
                    onClick = { expanded = false },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .testTag("fab_menu_option_1")
                        .focusable()
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Option 1")
                }
            }
            FloatingActionButton(
                onClick = { expanded = !expanded },
                modifier = Modifier
                    .testTag("fab_menu_toggle")
                    .focusable()
            ) {
                Icon(if (expanded) Icons.Default.Edit else Icons.Default.Menu, contentDescription = "Menu")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FabShowcasePreview() {
    FabShowcase()
}
