package com.creative.uienginesampleapp.action_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.assertions.assertTagDisplayed
import com.sehmi.engine.assertions.assertTagDoesNotExist
import androidx.compose.ui.test.junit4.ComposeTestRule

class FabRobot : ComposeRuleScope {

    fun verifyFabVisible(tag: String) {
        assertTagDisplayed(tag)
    }

    fun verifyFabIsNotVisible(tag: String) {
        assertTagDoesNotExist(tag)
    }

    fun verifyMenuOptionNotExists(tag: String) {
        assertTagDoesNotExist(tag)
    }

    fun clickStandardFab() {
        clickOnTag("fab_standard")
    }

    fun clickLargeFab() {
        clickOnTag("fab_large")
    }

    fun clickExtendedFab() {
        clickOnTag("fab_extended")
    }

    fun toggleMenu() {
        clickOnTag("fab_menu_toggle")
    }

    fun clickMenuOption() {
        clickOnTag("fab_menu_option_1")
    }
}
