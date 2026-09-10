package com.creative.uienginesampleapp.text_input_components

import com.creative.uienginesampleapp.text_input_components.robots.SliderRobot
import com.sehmi.engine.UiEngine
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SliderShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            SliderShowcase()
        }
    }

    @Test
    fun testContinuousSlider() {
        UiEngine.withRobot(SliderRobot()) {
            verifySliderVisible("slider_continuous")
            setSlider("slider_continuous", 0.5f)
            verifyValue("slider_continuous", "0.5")
        }
    }

    @Test
    fun testDiscreteSlider() {
        UiEngine.withRobot(SliderRobot()) {
            verifySliderVisible("slider_discrete")
            setSlider("slider_discrete", 0.8f) // Should snap to step
            verifyValue("slider_discrete", "80.0")
        }
    }

    @Test
    fun testRangeSlider() {
        UiEngine.withRobot(SliderRobot()) {
            verifySliderVisible("slider_range")
            // Range slider interactions might need more specific robot actions if library supports it
        }
    }
}
