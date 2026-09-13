package com.creative.uienginesampleapp.layout_containers

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.layout_containers.robots.LayoutRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LayoutShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            LayoutShowcase()
        }
    }

    @Test
    fun testLayoutContainersVisibility() {
        UiEngine.withRobot(LayoutRobot()) {
            verifyColumnVisible()
            verifyRowVisible()
            verifyBoxVisible()
        }
    }
}
