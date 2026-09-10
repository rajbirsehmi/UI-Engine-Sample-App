package com.creative.uienginesampleapp.text_input_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickAtOffset
import com.sehmi.engine.assertions.assertTagDisplayed
import com.sehmi.engine.assertions.assertValueEquals

class SliderRobot : ComposeRuleScope {
    fun verifySliderVisible(tag: String) {
        assertTagDisplayed(tag)
    }

    fun setSlider(tag: String, value: Float) {
        clickAtOffset(tag, value, 0.5f)
    }

    fun verifyValue(tag: String, expectedValue: String) {
        assertValueEquals(tag, expectedValue)
    }
}
