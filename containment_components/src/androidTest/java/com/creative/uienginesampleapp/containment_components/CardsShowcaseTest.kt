package com.creative.uienginesampleapp.containment_components

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.containment_components.robots.CardsRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CardsShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            CardsShowcase()
        }
    }

    @Test
    fun testCardsVisibility() {
        UiEngine.withRobot(CardsRobot()) {
            verifyCardVisible("card_filled")
            verifyCardVisible("card_elevated")
            verifyCardVisible("card_outlined")
        }
    }
}
