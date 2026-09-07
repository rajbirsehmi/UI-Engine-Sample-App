# UI Engine Sample App

Welcome to the **UI Engine Sample App**! This repository serves as a live demonstration and reference implementation for integrating and using the [UI-Engine](https://github.com/rajbirsehmi/UI-Engine) library in a modern Jetpack Compose application.

## 🚀 Purpose

The goal of this sample app is to showcase how to build robust, maintainable, and flake-free UI tests using the UI-Engine framework. It provides a variety of UI components and patterns, along with their corresponding "Robot-based" tests to illustrate best practices in Android UI automation.

## 🛠 Features Showcased

This app includes several categories of UI components designed to be tested with UI-Engine:

- **Action Components:** Buttons, FABs, and clickable elements.
- **Text & Input Controls:** TextFields, Switches, and complex form entries.
- **Containment & Structure:** Cards, Bottom Sheets, and dynamic lists.
- **Navigation Components:** Top App Bars, Navigation Rails, and Drawers.
- **Communication & Feedback:** Snackbars, Dialogs, and Progress indicators.
- **Layout Containers:** Box, Column, Row, and Scaffold arrangements.

## 🏗 Built With

- **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Modern toolkit for building native UI.
- **[UI-Engine](https://github.com/rajbirsehmi/UI-Engine):** Industrial-grade testing framework for Compose.
- **Material 3:** The latest evolution of Material Design.
- **Kotlin Coroutines:** For asynchronous operations.

## 🧪 Testing with UI-Engine

The core of this sample app lies in its `androidTest` folder. We use the **Robot Pattern** provided by UI-Engine to separate "what" we test from "how" we interact with the UI.

### Example Robot Test

```kotlin
@Test
fun testSubmitButtonClick() {
    withRobot(ActionRobot::class) {
        clickOnTag("submit_button")
        assertTextEquals("success_message", "Form Submitted!")
    }
}
```

Key UI-Engine benefits demonstrated:
- **Auto-Scrolling:** Interactions automatically scroll elements into view.
- **Robustness Pipeline:** Built-in polling and synchronization.
- **Diagnostics:** Automatic failure screenshots and semantics tree dumps.

## 📥 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/rajbirsehmi/UI-Engine-Sample-App.git
```

### 2. Add UI-Engine to your Project
To use UI-Engine in your own app, add the following to your `build.gradle`:

```kotlin
dependencies {
    androidTestImplementation("com.github.rajbirsehmi:ui-engine:latest_version")
    // If using the Lint module
    lintChecks("com.github.rajbirsehmi:ui-engine-lint:latest_version")
}
```

### 3. Run the Tests
You can run the showcased tests directly from Android Studio or via Gradle:
```bash
./gradlew connectedDebugAndroidTest
```

## 🔗 Links

- **UI-Engine Library:** [https://github.com/rajbirsehmi/UI-Engine](https://github.com/rajbirsehmi/UI-Engine)
- **Author:** [Rajbir Sehmi](https://github.com/rajbirsehmi)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
