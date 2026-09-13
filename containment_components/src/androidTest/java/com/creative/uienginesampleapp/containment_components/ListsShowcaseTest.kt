package com.creative.uienginesampleapp.containment_components

import com.sehmi.engine.UiEngine
import com.creative.uienginesampleapp.containment_components.robots.ListsRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ListsShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            ListsShowcase()
        }
    }

    @Test
    fun testListItemsVisibility() {
        UiEngine.withRobot(ListsRobot()) {
            verifyListItemVisible("list_item_item_1")
            verifyListItemVisible("list_item_item_2")
            verifyListItemVisible("list_item_item_3")
            verifyListItemVisible("list_item_item_4")
        }
    }
}
