package com.creative.uienginesampleapp.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.*
import com.sehmi.engine.assertions.*

class GesturesRobot : ComposeRuleScope {
    fun testBasicGestures() {
        clickOnTag("gesture_box")
        assertTagDisplayed("gesture_box")
        
        doubleClickTag("gesture_box")
        assertTagDisplayed("gesture_box")
        
        longClickTag("gesture_box")
        assertTagDisplayed("gesture_box")
    }

    fun testDragAndDrop() {
        dragAndDrop(sourceTag = "drag_box", targetTag = "gesture_box")
    }

    fun testTransformations() {
        pinchToZoom("transform_box", zoomIn = true)
        rotate("transform_box", degrees = 90f)
    }

    fun testMultiFinger() {
        multiFingerSwipe("multi_finger_label", fingers = 2, direction = Direction.DOWN)
    }
}
