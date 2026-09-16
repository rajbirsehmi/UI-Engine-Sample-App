package com.creative.uienginesampleapp.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.*
import com.sehmi.engine.assertions.*

class SystemRobot : ComposeRuleScope {
    fun testSystemActions() {
        // Test Back/Home (Navigation handled in test suite usually)
        
        // Permissions (Camera and Notifications)
        clickOnTag("permission_button")
        handlePermissionDialog(allow = true) // Handle Camera
        handlePermissionDialog(allow = true) // Handle Notifications (Android 13+)
        
        // Notification
        clickOnTag("notification_button")
        openNotificationShade()
        clickNotification("My App Test")
        
        // Quick Settings
        toggleQuickSetting("Wi-Fi")
    }
}
