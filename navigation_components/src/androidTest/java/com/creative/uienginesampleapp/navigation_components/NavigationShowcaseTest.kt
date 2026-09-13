package com.creative.uienginesampleapp.navigation_components

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.navigation_components.robots.NavigationRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            NavigationShowcase()
        }
    }

    @Test
    fun testNavigationWorkflow() {
        UiEngine.withRobot(NavigationRobot()) {
            verifyNavBarVisible()
            clickNavItem(1)
            clickNavItem(2)
        }
    }
}
