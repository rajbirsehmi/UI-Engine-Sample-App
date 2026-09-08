package com.creative.uienginesampleapp.action_components

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.action_components.robots.IconButtonRobot
import com.sehmi.engine.actions.advanceTime
import com.sehmi.engine.actions.requestFocus
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class IconButtonShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            IconButtonShowcase()
        }
    }

    @Test
    fun testIconButtonStandard() {
        UiEngine.withRobot(IconButtonRobot()) {
            verifyIsButtonEnabled("icon_button_standard")
            clickStandardIconButton()
        }
    }

    @Test
    fun testIconButtonFilled() {
        UiEngine.withRobot(IconButtonRobot()) {
            verifyIsButtonEnabled("icon_button_filled")
            clickFilledIconButton()
        }
    }

    @Test
    fun testIconButtonTonal() {
        UiEngine.withRobot(IconButtonRobot()) {
            verifyIsButtonEnabled("icon_button_tonal")
            clickTonalIconButton()
        }
    }

    @Test
    fun testIconButtonOutlined() {
        UiEngine.withRobot(IconButtonRobot()) {
            verifyIsButtonEnabled("icon_button_outlined")
            clickOutlinedIconButton()
        }
    }

    @Test
    fun testIconButtonToggle() {
        UiEngine.withRobot(IconButtonRobot()) {
            verifyIconNotSelected("icon_button_toggle")
            toggleIconButton()
            advanceTime(500)

            verifyIconSelected("icon_button_toggle")
            toggleIconButton()
            advanceTime(500)

            verifyIconNotSelected("icon_button_toggle")
        }
    }
}
