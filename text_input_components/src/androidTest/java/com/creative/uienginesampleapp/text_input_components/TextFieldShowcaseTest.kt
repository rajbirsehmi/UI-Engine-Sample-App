package com.creative.uienginesampleapp.text_input_components

import com.creative.uienginesampleapp.text_input_components.robots.TextFieldRobot
import com.sehmi.engine.UiEngine
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TextFieldShowcaseTest {

    @get:Rule
    val rule = UiEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            TextFieldShowcase()
        }
    }

    @Test
    fun testFilledTextFields() {
        UiEngine.withRobot(TextFieldRobot()) {
            verifyTextFieldVisible("tf_filled_basic")
            typeIntoField("tf_filled_basic", "Hello World")
            verifyText("tf_filled_basic", "Hello World")
            
            verifyTextFieldVisible("tf_filled_icons")
            typeIntoField("tf_filled_icons", "With Icons")
            verifyText("tf_filled_icons", "With Icons")
        }
    }

    @Test
    fun testOutlinedTextFields() {
        UiEngine.withRobot(TextFieldRobot()) {
            verifyTextFieldVisible("tf_outlined_basic")
            typeIntoField("tf_outlined_basic", "Outlined")
            verifyText("tf_outlined_basic", "Outlined")

            verifyTextFieldVisible("tf_outlined_email")
            typeIntoField("tf_outlined_email", "test@example.com")
            verifyText("tf_outlined_email", "test@example.com")
        }
    }

    @Test
    fun testPasswordFields() {
        UiEngine.withRobot(TextFieldRobot()) {
            verifyTextFieldVisible("tf_password")
            typeIntoField("tf_password", "mysecret")
            togglePasswordVisibility()
            // Verify functionality could be expanded here
        }
    }

    @Test
    fun testErrorAndDisabledStates() {
        UiEngine.withRobot(TextFieldRobot()) {
            verifyTextFieldVisible("tf_error")
            verifyTextFieldVisible("tf_disabled")
        }
    }
}
