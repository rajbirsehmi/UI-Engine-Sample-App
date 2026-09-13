package com.creative.uienginesampleapp.navigation_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.assertions.assertTagDisplayed

class NavigationRobot : ComposeRuleScope {
    fun verifyNavBarVisible() {
        assertTagDisplayed("navigation_bar")
    }

    fun clickNavItem(index: Int) {
        clickOnTag("nav_item_$index")
    }
}
