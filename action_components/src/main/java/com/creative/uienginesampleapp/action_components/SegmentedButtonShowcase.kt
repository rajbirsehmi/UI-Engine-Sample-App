package com.creative.uienginesampleapp.action_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.focusable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegmentedButtonShowcase() {
    val options = listOf("Day", "Month", "Year")
    var selectedIndex by remember { mutableStateOf(0) }
    val selectedIndices = remember { mutableStateListOf<Int>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Single Choice")
        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    onClick = { selectedIndex = index },
                    selected = index == selectedIndex,
                    modifier = Modifier
                        .testTag("segmented_single_$index")
                        .focusable()
                ) {
                    Text(label)
                }
            }
        }

        Text("Multi Choice")
        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    onCheckedChange = {
                        if (index in selectedIndices) {
                            selectedIndices.remove(index)
                        } else {
                            selectedIndices.add(index)
                        }
                    },
                    checked = index in selectedIndices,
                    modifier = Modifier
                        .testTag("segmented_multi_$index")
                        .focusable()
                ) {
                    Text(label)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SegmentedButtonShowcasePreview() {
    SegmentedButtonShowcase()
}
