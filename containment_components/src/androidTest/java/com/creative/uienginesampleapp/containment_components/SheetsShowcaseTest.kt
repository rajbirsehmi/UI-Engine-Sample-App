package com.creative.uienginesampleapp.containment_components

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.containment_components.robots.SheetsRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SheetsShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            SheetsShowcase()
        }
    }

    @Test
    fun testBottomSheetWorkflow() {
        UiEngine.withRobot(SheetsRobot()) {
            clickShowSheet()
            verifySheetVisible()
            verifySheetTitle("Bottom Sheet Content")
            clickDismissSheet()
        }
    }
}
