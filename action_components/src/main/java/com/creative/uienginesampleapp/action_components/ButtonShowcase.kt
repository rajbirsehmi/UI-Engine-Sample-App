package com.creative.uienginesampleapp.action_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.focusable
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonShowcase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { },
            modifier = Modifier
                .testTag("button_filled")
                .focusable()
        ) {
            Text("Filled Button")
        }
        ElevatedButton(
            onClick = { },
            modifier = Modifier
                .testTag("button_elevated")
                .focusable()
        ) {
            Text("Elevated Button")
        }
        FilledTonalButton(
            onClick = { },
            modifier = Modifier
                .testTag("button_tonal")
                .focusable()
        ) {
            Text("Filled Tonal Button")
        }
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .testTag("button_outlined")
                .focusable()
        ) {
            Text("Outlined Button")
        }
        TextButton(
            onClick = { },
            modifier = Modifier
                .testTag("button_text")
                .focusable()
        ) {
            Text("Text Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonShowcasePreview() {
    ButtonShowcase()
}