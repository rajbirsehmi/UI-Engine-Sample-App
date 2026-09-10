package com.creative.uienginesampleapp.text_input_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SelectionControlsShowcase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        SectionTitle("Switches")
        SwitchShowcase()

        HorizontalDivider()

        SectionTitle("Checkboxes")
        CheckboxShowcase()

        HorizontalDivider()

        SectionTitle("Radio Buttons")
        RadioButtonShowcase()
    }
}

@Composable
fun SwitchShowcase() {
    var checked1 by remember { mutableStateOf(true) }
    var checked2 by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = checked1,
                    onValueChange = { checked1 = it },
                    role = Role.Switch
                )
                .padding(vertical = 8.dp)
                .testTag("row_notifications"),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Notifications")
            Switch(
                checked = checked1,
                onCheckedChange = null
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = checked2,
                    onValueChange = { checked2 = it },
                    role = Role.Switch
                )
                .padding(vertical = 8.dp)
                .testTag("row_dark_mode"),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Dark Mode")
            Switch(
                checked = checked2,
                onCheckedChange = null
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .testTag("row_disabled_switch"),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Disabled Switch")
            Switch(
                checked = true,
                onCheckedChange = {},
                enabled = false,
                modifier = Modifier.testTag("switch_disabled")
            )
        }
    }
}

@Composable
fun CheckboxShowcase() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(true) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = checked1,
                    onValueChange = { checked1 = it },
                    role = Role.Checkbox
                )
                .padding(vertical = 8.dp)
                .testTag("row_terms"),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked1,
                onCheckedChange = null
            )
            Text("Accept Terms & Conditions", modifier = Modifier.padding(start = 8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = checked2,
                    onValueChange = { checked2 = it },
                    role = Role.Checkbox
                )
                .padding(vertical = 8.dp)
                .testTag("row_newsletter"),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked2,
                onCheckedChange = null
            )
            Text("Subscribe to Newsletter", modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun RadioButtonShowcase() {
    val radioOptions = listOf("Option A", "Option B", "Option C")
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }

    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { selectedOption = text },
                        role = Role.RadioButton
                    )
                    .padding(vertical = 8.dp)
                    .testTag("radio_row_${text.replace(" ", "_").lowercase()}"),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null, // null recommended for accessibility with screenreaders
                    modifier = Modifier.testTag("radio_button_${text.replace(" ", "_").lowercase()}")
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectionControlsShowcasePreview() {
    MaterialTheme {
        SelectionControlsShowcase()
    }
}
