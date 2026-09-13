package com.creative.uienginesampleapp.containment_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardsShowcase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("card_filled")
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Filled Card", style = MaterialTheme.typography.titleMedium)
                Text(text = "This is a standard filled card container.", style = MaterialTheme.typography.bodyMedium)
            }
        }

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("card_elevated")
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Elevated Card", style = MaterialTheme.typography.titleMedium)
                Text(text = "This is an elevated card with shadow depth.", style = MaterialTheme.typography.bodyMedium)
            }
        }

        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("card_outlined")
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Outlined Card", style = MaterialTheme.typography.titleMedium)
                Text(text = "This is an outlined card with a visible border.", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardsShowcasePreview() {
    CardsShowcase()
}
