package com.creative.uienginesampleapp.text_input_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.assertions.assertIsOn
import com.sehmi.engine.assertions.assertIsOff
import com.sehmi.engine.assertions.assertIsSelected
import com.sehmi.engine.assertions.assertTagDisplayed

class SelectionControlsRobot : ComposeRuleScope {
    fun verifyControlVisible(tag: String) {
        assertTagDisplayed(tag, useUnmergedTree = true)
    }

    fun clickControl(tag: String) {
        clickOnTag(tag)
    }

    fun verifyIsOn(tag: String) {
        assertIsOn(tag, useUnmergedTree = true)
    }

    fun verifyIsOff(tag: String) {
        assertIsOff(tag, useUnmergedTree = true)
    }

    fun verifyIsSelected(tag: String) {
        assertIsSelected(tag, useUnmergedTree = true)
    }
}
