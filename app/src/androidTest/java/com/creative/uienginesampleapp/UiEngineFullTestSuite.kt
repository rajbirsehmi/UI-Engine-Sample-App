package com.creative.uienginesampleapp

import com.creative.uienginesampleapp.robots.*
import com.creative.uienginesampleapp.ui.theme.UIEngineSampleAppTheme
import com.sehmi.engine.UiTestEngine
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

    @Before
    fun acceptNotificationPermission() {
        UiTestEngine.enablePermission("android.permission.POST_NOTIFICATIONS")
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
    fun testPermissionSystemActions() {
        UiTestEngine.withRobot(MainRobot()) {
            navigateToSystem()
        }
        UiTestEngine.withRobot(SystemRobot()) {
            testPermissionSystemActions()
        }
    }

    @Test
    fun testNotificationSystemActions() {
        UiTestEngine.withRobot(MainRobot()) {
            navigateToSystem()
        }
        UiTestEngine.withRobot(SystemRobot()) {
            testNotificationSystemActions()
        }
        UiTestEngine.withRobot(MainRobot()) {
            goHome()
        }
    }

    @Test
    fun testToggleSystemActions() {
        UiTestEngine.withRobot(MainRobot()) {
            navigateToSystem()
        }
        UiTestEngine.withRobot(SystemRobot()) {
            testToggleSystemActions()
        }
        UiTestEngine.withRobot(MainRobot()) {
            goHome()
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
