package com.creative.uienginesampleapp.text_input_components

import com.creative.uienginesampleapp.text_input_components.robots.SelectionControlsRobot
import com.sehmi.engine.UiEngine
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SelectionControlsShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            SelectionControlsShowcase()
        }
    }

    @Test
    fun testSwitches() {
        UiEngine.withRobot(SelectionControlsRobot()) {
            verifyControlVisible("row_notifications")
            verifyIsOn("row_notifications")
            clickControl("row_notifications")
            verifyIsOff("row_notifications")

            verifyControlVisible("row_dark_mode")
            verifyIsOff("row_dark_mode")
            clickControl("row_dark_mode")
            verifyIsOn("row_dark_mode")
        }
    }

    @Test
    fun testCheckboxes() {
        UiEngine.withRobot(SelectionControlsRobot()) {
            verifyControlVisible("row_terms")
            verifyIsOff("row_terms")
            clickControl("row_terms")
            verifyIsOn("row_terms")

            verifyControlVisible("row_newsletter")
            verifyIsOn("row_newsletter")
            clickControl("row_newsletter")
            verifyIsOff("row_newsletter")
        }
    }

    @Test
    fun testRadioButtons() {
        UiEngine.withRobot(SelectionControlsRobot()) {
            verifyControlVisible("radio_row_option_a")
            verifyIsSelected("radio_row_option_a")

            clickControl("radio_row_option_b")
            verifyIsSelected("radio_row_option_b")
            
            clickControl("radio_row_option_c")
            verifyIsSelected("radio_row_option_c")
        }
    }
}
