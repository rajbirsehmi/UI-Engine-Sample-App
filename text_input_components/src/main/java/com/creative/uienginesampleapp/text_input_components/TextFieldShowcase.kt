package com.creative.uienginesampleapp.text_input_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldShowcase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        SectionTitle("Filled Text Fields")
        FilledTextFields()

        HorizontalDivider()

        SectionTitle("Outlined Text Fields")
        OutlinedTextFields()

        HorizontalDivider()

        SectionTitle("Special States")
        SpecialStateTextFields()
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun FilledTextFields() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Basic Filled") },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("tf_filled_basic")
        )

        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("With Leading & Trailing Icons") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            trailingIcon = { Icon(Icons.Default.Info, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("tf_filled_icons")
        )
    }
}

@Composable
fun OutlinedTextFields() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        OutlinedTextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Basic Outlined") },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("tf_outlined_basic")
        )

        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Email Address") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("tf_outlined_email")
        )
    }
}

@Composable
fun SpecialStateTextFields() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var errorText by remember { mutableStateOf("Invalid input") }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                IconButton(
                    onClick = { passwordVisible = !passwordVisible },
                    modifier = Modifier.testTag("tf_password_visibility_toggle")
                ) {
                    Icon(image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("tf_password")
        )

        TextField(
            value = errorText,
            onValueChange = { errorText = it },
            label = { Text("Error State") },
            isError = true,
            supportingText = { Text("This field has an error") },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("tf_error")
        )

        TextField(
            value = "Disabled Text",
            onValueChange = {},
            label = { Text("Disabled") },
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("tf_disabled")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldShowcasePreview() {
    MaterialTheme {
        TextFieldShowcase()
    }
}
