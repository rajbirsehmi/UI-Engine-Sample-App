package com.creative.uienginesampleapp.action_components

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.action_components.robots.FabRobot
import com.sehmi.engine.actions.advanceTime
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FabShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            FabShowcase()
        }
    }

    @Test
    fun testFabStandard() {
        UiEngine.withRobot(FabRobot()) {
            verifyFabVisible("fab_standard")
            clickStandardFab()
        }
    }

    @Test
    fun testFabLarge() {
        UiEngine.withRobot(FabRobot()) {
            verifyFabVisible("fab_large")
            clickLargeFab()
        }
    }

    @Test
    fun testFabExtended() {
        UiEngine.withRobot(FabRobot()) {
            verifyFabVisible("fab_extended")
            clickExtendedFab()
        }
    }

    @Test
    fun testFabMenu() {
        UiEngine.withRobot(FabRobot()) {
            verifyFabVisible("fab_menu_toggle")
            toggleMenu()
            advanceTime(500)
            verifyFabVisible("fab_menu_option_1")
            clickMenuOption()
            advanceTime(500)
            verifyFabIsNotVisible("fab_menu_option_1")
        }
    }
}