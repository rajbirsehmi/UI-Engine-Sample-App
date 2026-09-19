package com.creative.uienginesampleapp.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.actions.pressHome
import com.sehmi.engine.assertions.assertTagDisplayed

class MainRobot : ComposeRuleScope {
    
   fun navigateToGestures() {
       assertTagDisplayed("category_gestures")
       clickOnTag("category_gestures")
   }

    fun navigateToTextInput() {
        assertTagDisplayed("category_text_input")
        clickOnTag("category_text_input")
    }

    fun navigateToScrolling() {
        assertTagDisplayed("category_scrolling")
        clickOnTag("category_scrolling")
    }

    fun navigateToSystem() {
        assertTagDisplayed("category_system")
        clickOnTag("category_system")
    }

    fun navigateToAccessibility() {
        assertTagDisplayed("category_accessibility")
        clickOnTag("category_accessibility")
    }

    fun backToMain() {
        assertTagDisplayed("back_button")
        clickOnTag("back_button")
    }

    fun goHome() {
        pressHome()
    }
}
