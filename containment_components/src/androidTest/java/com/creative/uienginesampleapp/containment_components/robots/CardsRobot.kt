package com.creative.uienginesampleapp.containment_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.assertions.assertTagDisplayed

class CardsRobot : ComposeRuleScope {
    fun verifyCardVisible(tag: String) {
        assertTagDisplayed(tag)
    }
}
