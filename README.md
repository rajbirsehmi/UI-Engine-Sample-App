# UI Engine Sample App

Welcome to the **UI Engine Sample App**! This repository serves as a comprehensive demonstration and reference implementation for integrating and using the [UI-Engine](https://github.com/rajbirsehmi/UI-Engine) framework (`robot-testing-engine`) in a modern Jetpack Compose application.

## 🚀 Purpose

The goal of this sample app is to showcase how to build robust, maintainable, highly structured, and flake-free UI tests using the **Robot Testing Pattern** powered by the `UI-Engine` library.

## 🏗 Project Architecture

The project is structured as a streamlined, single-module Jetpack Compose application (`:app`) showcasing key categories of UI interactions and system-level actions:

- **Showcase Screens (`app/src/main`)**: Interactive screens demonstrating Compose UI components, gestures, text inputs, scrolling containers, system permissions/notifications, and accessibility configurations.
- **Robot Test Suite (`app/src/androidTest`)**: Modular **Robot Pattern** test implementations that encapsulate test assertions, gestures, scrolling operations, and system interactions using `com.sehmi.engine.UiTestEngine`.

---

## 🛠 Feature Showcase Categories & Engine Capabilities

### 👆 1. Gestures
Demonstrates advanced touch and gesture handling using UI-Engine's gesture actions:
- **Basic Tap & Press**: `clickOnTag`, `doubleClickTag`, `longClickTag`
- **Drag & Drop**: `dragAndDrop` from source to target bounds
- **Transformations**: `pinchToZoom` and `rotate`
- **Multi-finger Swipes**: `multiFingerSwipe` for multi-touch gestures

### ✍️ 2. Text Input
Demonstrates text field interactions and IME focus:
- `enterText` and `replaceText`
- `clear_button` click actions and text assertions (`assertTextContains`, `assertTextEquals`)
- Focus management via `requestFocus` and IME actions (`pressImeAction`)

### 📜 3. Scrolling
Demonstrates lazy list navigation and dynamic item scrolling:
- Scroll by index via `scrollToIndex`
- Infinite or lazy container traversal using `swipeUntilVisible` and `scrollToTag`

### ⚙️ 4. System Actions
Demonstrates interactions with Android OS level components:
- **Permissions**: `handlePermissionDialog` to automatically accept/deny runtime permission requests
- **Notifications**: `openNotificationShade` and `clickNotification` to test system notifications
- **Quick Settings**: `toggleQuickSetting` to toggle system settings
- **System Navigation**: `pressHome` and back navigation

### ♿ 5. Accessibility
Demonstrates accessibility assertions and navigation:
- `navigateByAccessibility` traversal in specific directions
- `assertFocusOrder` to verify accessibility focus sequences
- `assertInteractiveNodesHaveLabels` to ensure interactive UI elements satisfy accessibility content descriptions

---

## 🤖 Robot Testing Pattern Setup

All instrumented UI tests are structured using `UiTestEngine` with `ComposeRuleScope` and modular Robot classes:

| Robot Class | Core Responsibilities |
| :--- | :--- |
| **`MainRobot`** | Main dashboard navigation (`navigateToGestures`, `navigateToTextInput`, etc.) and system home action (`pressHome`) |
| **`GesturesRobot`** | Basic clicks, drag-and-drop, zoom/rotate transformations, and multi-finger swipes |
| **`TextInputRobot`** | Requesting field focus, entering/replacing text, clearing input, and verifying output |
| **`ScrollingRobot`** | Index-based scrolling and `swipeUntilVisible` on `LazyColumn` items |
| **`SystemRobot`** | Interacting with OS permissions dialogs, notification shade, and quick settings toggles |
| **`AccessibilityRobot`** | Verifying accessibility focus order and interactive node content descriptions |

### Sample Test Suite (`UiEngineFullTestSuite.kt`)
```kotlin
class UiEngineFullTestSuite {

    @get:Rule
    val rule = UiTestEngine.createRule()

    @Before
    fun setup() {
        rule.setContent {
            UIEngineSampleAppTheme {
                MainScreen()
            }
        }
    }

    @Test
    fun testTextInput() {
        UiTestEngine.withRobot(MainRobot()) {
            navigateToTextInput()
        }
        UiTestEngine.withRobot(TextInputRobot()) {
            requestFocusTo("input_field")
            enterTextInto("input_field", "Hello")
            assertTextIn("text_output", "Current: Hello")
            replaceTextIn("input_field", "World")
            assertTextIn("text_output", "Current: World")
            clickClearButton()
            assertTextIn("text_output", "Current: ")
        }
    }
}
```

---

## 📥 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/rajbirsehmi/UI-Engine-Sample-App.git
```

### 2. Run the App
Open the project in Android Studio (Ladybug or newer) and deploy the `:app` configuration on an emulator or physical device.

### 3. Execute UI Tests Locally
Run all automated UI tests on a connected emulator or device via Gradle:
```bash
./gradlew connectedAndroidTest
```

---

## ⚙️ Tech Stack & Dependencies

- **Language**: Kotlin `2.4.20`
- **UI Framework**: Jetpack Compose (BOM `2026.09.00`) & Material 3
- **Test Engine**: [UI-Engine](https://github.com/rajbirsehmi/UI-Engine) (`0.3.0-rc04`)
- **Build System**: Android Gradle Plugin `9.4.1`

---

## 🔗 Links

- **UI-Engine Framework:** [https://github.com/rajbirsehmi/UI-Engine](https://github.com/rajbirsehmi/UI-Engine)
- **Author:** [Rajbir Sehmi](https://github.com/rajbirsehmi)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

