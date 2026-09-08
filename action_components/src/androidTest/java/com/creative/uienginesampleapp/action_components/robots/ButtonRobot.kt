package com.creative.uienginesampleapp.action_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.assertions.assertTagDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule

class ButtonRobot : ComposeRuleScope {
    fun verifyButtonVisible(tag: String) {
        assertTagDisplayed(tag)
    }
    
    fun clickFilledButton() {
        clickOnTag("button_filled")
    }

    fun clickElevatedButton() {
        clickOnTag("button_elevated")
    }

    fun clickTonalButton() {
        clickOnTag("button_tonal")
    }

    fun clickOutlinedButton() {
        clickOnTag("button_outlined")
    }

    fun clickTextButton() {
        clickOnTag("button_text")
    }
}
