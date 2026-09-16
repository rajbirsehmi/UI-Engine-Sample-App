package com.creative.uienginesampleapp.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.*
import com.sehmi.engine.assertions.*

class TextInputRobot : ComposeRuleScope {

    fun requestFocusTo(tag: String) {
        requestFocus(tag)
    }

    fun enterTextInto(tag: String, text: String) {
        enterText(tag, text)
    }

    fun assertTextIn(tag: String, expectedText: String) {
        assertTextContains(tag, expectedText)
    }

    fun replaceTextIn(tag: String, text: String) {
        replaceText(tag, text)
    }

    fun clickClearButton() {
        clickOnTag("clear_button")
    }

    fun pressImeActionIn(tag: String) {
        pressImeAction(tag)
    }

    fun assertTextEqualsTo(tag: String, expectedText: String) {
        assertTextEquals(tag, expectedText)
    }
}
