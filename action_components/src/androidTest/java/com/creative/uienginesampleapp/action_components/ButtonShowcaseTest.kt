package com.creative.uienginesampleapp.action_components

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.action_components.robots.ButtonRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ButtonShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            ButtonShowcase()
        }
    }

    @Test
    fun testButtonFilled() {
        UiEngine.withRobot(ButtonRobot()) {
            verifyButtonVisible("button_filled")
            clickFilledButton()
        }
    }

    @Test
    fun testButtonElevated() {
        UiEngine.withRobot(ButtonRobot()) {
            verifyButtonVisible("button_elevated")
            clickElevatedButton()
        }
    }

    @Test
    fun testButtonTonal() {
        UiEngine.withRobot(ButtonRobot()) {
            verifyButtonVisible("button_tonal")
            clickTonalButton()
        }
    }

    @Test
    fun testButtonOutlined() {
        UiEngine.withRobot(ButtonRobot()) {
            verifyButtonVisible("button_outlined")
            clickOutlinedButton()
        }
    }

    @Test
    fun testButtonText() {
        UiEngine.withRobot(ButtonRobot()) {
            verifyButtonVisible("button_text")
            clickTextButton()
        }
    }
}
