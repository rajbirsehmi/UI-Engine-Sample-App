package com.creative.uienginesampleapp.containment_components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListsShowcase() {
    val listItems = listOf(
        "Item 1: Overview" to "Detailed documentation of core architecture.",
        "Item 2: Containers" to "Using Box, Column, and Row effectively.",
        "Item 3: Lists" to "LazyColumn optimization techniques.",
        "Item 4: Sheets" to "Modal Bottom Sheets for extra actions."
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .testTag("lists_lazy_column")
    ) {
        items(listItems) { (title, subtitle) ->
            ListItem(
                headlineContent = { Text(title) },
                supportingContent = { Text(subtitle) },
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Info Icon"
                    )
                },
                modifier = Modifier.testTag("list_item_${title.split(":")[0].replace(" ", "_").lowercase()}")
            )
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListsShowcasePreview() {
    ListsShowcase()
}
