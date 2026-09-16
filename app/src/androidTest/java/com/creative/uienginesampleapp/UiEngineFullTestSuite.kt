package com.creative.uienginesampleapp

import com.creative.uienginesampleapp.robots.*
import com.creative.uienginesampleapp.ui.theme.UIEngineSampleAppTheme
import com.sehmi.engine.UiTestEngine
import com.sehmi.engine.actions.clickOnTag
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UiEngineFullTestSuite {

    @get:Rule
    val rule = UiTestEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            UIEngineSampleAppTheme {
                MainScreen()
            }
        }
    }

    @Test
    fun testGestures() {
        UiTestEngine.withRobot(MainRobot()) {
            navigateToGestures()
        }
        UiTestEngine.withRobot(GesturesRobot()) {
            testBasicGestures()
            testDragAndDrop()
            testTransformations()
            testMultiFinger()
        }
    }

    @Test
    fun testTextInput() {
        UiTestEngine.withRobot(MainRobot()) {
            navigateToTextInput()
        }
        UiTestEngine.withRobot(TextInputRobot()) {
            requestFocusTo("input_field")
            enterTextInto("input_field", "Hello")
            assertTextIn("text_output", "Current: Hello")
            replaceTextIn("input_field", "World")
            assertTextIn("text_output", "Current: World")
            clickClearButton()
            assertTextIn("text_output", "Current: ")
        }
    }

    @Test
    fun testScrolling() {
        UiTestEngine.withRobot(MainRobot()) {
            navigateToScrolling()
        }
        UiTestEngine.withRobot(ScrollingRobot()) {
            scrollTo("lazy_list", 50)
            swipeToLast()
        }
    }

    @Test
    fun testSystemActions() {
        UiTestEngine.withRobot(MainRobot()) {
            navigateToSystem()
        }
        UiTestEngine.withRobot(SystemRobot()) {
            // needs engine update to handle the
            // system dialog interactions
        }
    }

    @Test
    fun testAccessibility() {
        UiTestEngine.withRobot(MainRobot()) {
            navigateToAccessibility()
        }
        UiTestEngine.withRobot(AccessibilityRobot()) {
            testAccessibility()
        }
    }
}
