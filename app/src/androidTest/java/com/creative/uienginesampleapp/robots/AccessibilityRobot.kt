package com.creative.uienginesampleapp.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.*
import com.sehmi.engine.assertions.*

class AccessibilityRobot : ComposeRuleScope {
    fun testAccessibility() {
        navigateByAccessibility(Direction.RIGHT)
        assertFocusOrder(listOf("btn_first", "btn_middle", "btn_last"))
        assertInteractiveNodesHaveLabels()
    }
}
