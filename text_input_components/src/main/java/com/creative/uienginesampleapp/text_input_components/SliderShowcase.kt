package com.creative.uienginesampleapp.text_input_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderShowcase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        SectionTitle("Continuous Slider")
        ContinuousSlider()

        HorizontalDivider()

        SectionTitle("Discrete Slider")
        DiscreteSlider()

        HorizontalDivider()

        SectionTitle("Range Slider")
        RangeSliderShowcase()
    }
}

@Composable
fun ContinuousSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("slider_continuous")
        )
        Text(text = "Value: ${"%.2f".format(sliderPosition)}")
    }
}

@Composable
fun DiscreteSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            steps = 9,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("slider_discrete")
        )
        Text(text = "Value: ${sliderPosition.toInt()}")
    }
}

@Composable
fun RangeSliderShowcase() {
    var sliderPosition by remember { mutableStateOf(20f..80f) }
    Column {
        RangeSlider(
            value = sliderPosition,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("slider_range")
        )
        Text(text = "Range: ${sliderPosition.start.toInt()} - ${sliderPosition.endInclusive.toInt()}")
    }
}

@Preview(showBackground = true)
@Composable
fun SliderShowcasePreview() {
    MaterialTheme {
        SliderShowcase()
    }
}
