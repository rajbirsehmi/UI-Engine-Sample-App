package com.creative.uienginesampleapp.containment_components.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.clickOnTag
import com.sehmi.engine.assertions.assertTagDisplayed

class SheetsRobot : ComposeRuleScope {
    fun clickShowSheet() {
        clickOnTag("btn_show_sheet")
    }

    fun verifySheetVisible() {
        assertTagDisplayed("modal_bottom_sheet")
    }

    fun verifySheetTitle(expectedText: String) {
        assertTagDisplayed("sheet_title")
    }

    fun clickDismissSheet() {
        clickOnTag("btn_close_sheet")
    }
}
