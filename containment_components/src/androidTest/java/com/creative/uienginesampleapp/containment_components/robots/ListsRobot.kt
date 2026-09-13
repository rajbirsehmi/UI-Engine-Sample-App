package com.creative.uienginesampleapp.containment_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.assertions.assertTagDisplayed

class ListsRobot : ComposeRuleScope {
    fun verifyListItemVisible(tag: String) {
        assertTagDisplayed(tag)
    }
}
