package com.creative.uienginesampleapp.communication_components

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.communication_components.robots.CommunicationRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CommunicationShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            CommunicationShowcase()
        }
    }

    @Test
    fun testProgressIndicatorsVisibility() {
        UiEngine.withRobot(CommunicationRobot()) {
            verifyCircularProgressVisible()
            verifyLinearProgressVisible()
        }
    }
}
