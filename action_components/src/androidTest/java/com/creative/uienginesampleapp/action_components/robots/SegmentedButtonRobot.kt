package com.creative.uienginesampleapp.action_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.assertions.assertIsSelected
import com.sehmi.engine.assertions.assertIsOn
import com.sehmi.engine.assertions.assertIsOff
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.sehmi.engine.assertions.assertIsNotSelected

class SegmentedButtonRobot : ComposeRuleScope {
    fun verifyOptionSelected(tag: String) {
        assertIsSelected(tag)
    }

    fun verifyOptionNotSelected(index: Int) {
        assertIsNotSelected("segmented_single_$index")
    }

    fun verifyOptionOn(tag: String) {
        assertIsOn(tag)
    }

    fun verifyOptionOff(tag: String) {
        assertIsOff(tag)
    }

    fun selectSingleOption(index: Int) {
        clickOnTag("segmented_single_$index")
    }

    fun toggleMultiOption(index: Int) {
        clickOnTag("segmented_multi_$index")
    }
}
