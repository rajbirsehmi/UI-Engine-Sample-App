package com.creative.uienginesampleapp.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.assertions.assertTagDisplayed

class MainRobot : ComposeRuleScope {
    
    fun verifyMainScreenDisplayed() {
        assertTagDisplayed("category_action_components")
    }

    fun clickActionComponentsCategory() {
        clickOnTag("category_action_components")
    }

    fun verifyActionComponentsListDisplayed() {
        assertTagDisplayed("action_components_list")
    }

    fun clickBackButton() {
        clickOnTag("back_button")
    }
}
