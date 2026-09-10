package com.creative.uienginesampleapp.text_input_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.enterText
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.assertions.assertTagDisplayed
import com.sehmi.engine.assertions.assertTextContains

class TextFieldRobot : ComposeRuleScope {
    fun verifyTextFieldVisible(tag: String) {
        assertTagDisplayed(tag)
    }

    fun typeIntoField(tag: String, text: String) {
        enterText(tag, text)
    }

    fun verifyText(tag: String, expectedText: String) {
        assertTextContains(tag, expectedText)
    }

    fun togglePasswordVisibility() {
        clickOnTag("tf_password_visibility_toggle")
    }
}
