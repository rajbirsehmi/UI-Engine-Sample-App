package com.creative.uienginesampleapp.layout_containers.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.assertions.assertTagDisplayed

class LayoutRobot : ComposeRuleScope {
    fun verifyColumnVisible() {
        assertTagDisplayed("layout_column")
    }

    fun verifyRowVisible() {
        assertTagDisplayed("layout_row")
    }

    fun verifyBoxVisible() {
        assertTagDisplayed("layout_box")
    }
}
