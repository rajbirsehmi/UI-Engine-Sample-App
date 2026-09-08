package com.creative.uienginesampleapp.action_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.assertions.assertIsDisabled
import com.sehmi.engine.assertions.assertIsOn
import com.sehmi.engine.assertions.assertIsOff
import com.sehmi.engine.assertions.assertIsEnabled

class IconButtonRobot : ComposeRuleScope {
    fun verifyIconSelected(tag: String) {
        assertIsOn(tag)
    }

    fun verifyIsButtonEnabled(tag: String) {
        assertIsEnabled(tag)
    }

    fun verifyIsButtonDisabled(tag: String) {
        assertIsDisabled(tag)
    }

    fun verifyIconNotSelected(tag: String) {
        assertIsOff(tag)
    }

    fun clickStandardIconButton() {
        clickOnTag("icon_button_standard")
    }

    fun clickFilledIconButton() {
        clickOnTag("icon_button_filled")
    }

    fun clickTonalIconButton() {
        clickOnTag("icon_button_tonal")
    }

    fun clickOutlinedIconButton() {
        clickOnTag("icon_button_outlined")
    }

    fun toggleIconButton() {
        clickOnTag("icon_button_toggle")
    }
}
