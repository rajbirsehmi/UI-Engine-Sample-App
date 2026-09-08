package com.creative.uienginesampleapp.action_components

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.action_components.robots.SegmentedButtonRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SegmentedButtonShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            SegmentedButtonShowcase()
        }
    }

    @Test
    fun testSegmentedButtonSingleOptionDay() {
        UiEngine.withRobot(SegmentedButtonRobot()) {
            selectSingleOption(0)
            verifyOptionSelected("segmented_single_0")
            verifyOptionNotSelected(1)
            verifyOptionNotSelected(2)
        }
    }

    @Test
    fun testSegmentedButtonSingleOptionMonth() {
        UiEngine.withRobot(SegmentedButtonRobot()) {
            selectSingleOption(1)
            verifyOptionSelected("segmented_single_1")
            verifyOptionNotSelected(0)
            verifyOptionNotSelected(2)
        }
    }

    @Test
    fun testSegmentedButtonSingleOptionYear() {
        UiEngine.withRobot(SegmentedButtonRobot()) {
            selectSingleOption(2)
            verifyOptionSelected("segmented_single_2")
            verifyOptionNotSelected(1)
            verifyOptionNotSelected(0)
        }
    }

    @Test
    fun testSegmentedButtonMultiOptionDay() {
        UiEngine.withRobot(SegmentedButtonRobot()) {
            toggleMultiOption(0)
            verifyOptionOn("segmented_multi_0")
            verifyOptionOff("segmented_multi_1")
            verifyOptionOff("segmented_multi_2")
        }
    }

    @Test
    fun testSegmentedButtonMultiOptionMonth() {
        UiEngine.withRobot(SegmentedButtonRobot()) {
            toggleMultiOption(0)
            toggleMultiOption(1)
            verifyOptionOn("segmented_multi_0")
            verifyOptionOn("segmented_multi_1")
            verifyOptionOff("segmented_multi_2")
        }
    }

    @Test
    fun testSegmentedButtonMultiOptionYear() {
        UiEngine.withRobot(SegmentedButtonRobot()) {
            toggleMultiOption(0)
            toggleMultiOption(1)
            toggleMultiOption(2)
            verifyOptionOn("segmented_multi_0")
            verifyOptionOn("segmented_multi_1")
            verifyOptionOn("segmented_multi_2")
        }
    }
}
