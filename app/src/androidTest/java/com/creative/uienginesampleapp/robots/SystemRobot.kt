package com.creative.uienginesampleapp.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.*
import com.sehmi.engine.assertions.*

class SystemRobot : ComposeRuleScope {

    fun testPermissionSystemActions() {
        clickOnTag("permission_button")
        handlePermissionDialog(allow = true) // Handle Camera
    }

    fun testNotificationSystemActions() {
//        handlePermissionDialog(allow = true) // Handle Notifications (Android 13+)
        clickOnTag("notification_button")
        openNotificationShade()
        clickNotification("My App Test")
    }

    fun testToggleSystemActions() {
        toggleQuickSetting("Internet")
    }
}
