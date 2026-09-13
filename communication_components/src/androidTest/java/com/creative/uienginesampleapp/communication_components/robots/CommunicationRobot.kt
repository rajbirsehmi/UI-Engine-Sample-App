package com.creative.uienginesampleapp.communication_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.assertions.assertTagDisplayed

class CommunicationRobot : ComposeRuleScope {
    fun verifyCircularProgressVisible() {
        assertTagDisplayed("circular_progress")
    }

    fun verifyLinearProgressVisible() {
        assertTagDisplayed("linear_progress")
    }
}
