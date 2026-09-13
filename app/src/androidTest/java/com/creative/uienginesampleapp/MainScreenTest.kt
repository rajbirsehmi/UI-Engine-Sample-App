package com.creative.uienginesampleapp

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.robots.MainRobot
import com.creative.uienginesampleapp.ui.theme.UIEngineSampleAppTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            UIEngineSampleAppTheme {
                MainScreen()
            }
        }
    }

    @Test
    fun testNavigationToActionComponents() {
        UiEngine.withRobot(MainRobot()) {
            verifyMainScreenDisplayed()
            clickActionComponentsCategory()
            verifyActionComponentsListDisplayed()
            clickBackButton()
            verifyMainScreenDisplayed()
        }
    }
}
