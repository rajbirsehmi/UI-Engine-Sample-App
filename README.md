# UI Engine Sample App

Welcome to the **UI Engine Sample App**! This repository serves as a comprehensive demonstration and reference implementation for integrating and using the [UI-Engine](https://github.com/rajbirsehmi/UI-Engine) library in a modular, modern Jetpack Compose application.

## 🚀 Purpose

The goal of this sample app is to showcase how to build robust, maintainable, highly structured, and flake-free UI tests using the **Robot Testing Pattern** powered by the UI-Engine framework.

## 🏗 Project Architecture & Modules

The application is split into highly focused, independent feature and utility library modules to enforce structural separation and scalable testing:

- **`:app`**: The main entry point containing the category dashboard, central entry points, and global navigation logic.
- **`:core-ui`**: Shared common UI theming elements, design token definitions, and Material 3 design adjustments.
- **`:action_components`**: Showcases standard action elements including Filled Buttons, Elevated Buttons, Outlined Buttons, Text Buttons, Segmented Buttons, and FABs.
- **`:text_input_components`**: Demonstrates inputs and selection controls including TextFields, Selection Controls (Sliders, Checkboxes, Switches).
- **`:containment_components`**: Showcases containment structures like Filled Cards, Elevated Cards, Outlined Cards, Modal Bottom Sheets, and Lazy Columns (`ListItem`).
- **`:navigation_components`**: Shows interactive global navigation structures like the Material 3 `NavigationBar`.
- **`:communication_components`**: Contains information feedback components like Circular and Linear Progress Indicators.
- **`:layout_containers`**: Illustrates layout structures like `Box`, `Row`, and `Column` arrangements.

## 🛠 Features & Robot Testing Pattern

Every individual module includes comprehensive instrumented tests structured under the **Robot Pattern** via `UiEngine`. This fully decouples the high-level test specifications from the underlying Espresso/Compose UI matchers:

- **Encapsulated View Assertions**: Dedicated `*Robot` classes inside each module's `androidTest` directory manage testing assertions and click interactions.
- **Fluent & Readable API**: High-level test bodies read precisely like functional workflows (e.g. `clickShowSheet()`, `verifySheetVisible()`).
- **CI Integrated Test Reporting**: Automated workflows bundle HTML test landing reports from each independent library module into a unified report package.

## 📥 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/rajbirsehmi/UI-Engine-Sample-App.git
```

### 2. Run the App
Open the project in Android Studio (Iguana / Ladybug or newer) and deploy the `:app` configuration on an emulator or a physical device.

### 3. Execute UI Tests Locally
You can run all the modularized UI tests on an emulator via Gradle:
```bash
./gradlew connectedAndroidTest
```
Or run the tests for a single specific library module:
```bash
./gradlew :containment_components:connectedAndroidTest
```

## 🔗 Links

- **UI-Engine Library:** [https://github.com/rajbirsehmi/UI-Engine](https://github.com/rajbirsehmi/UI-Engine)
- **Author:** [Rajbir Sehmi](https://github.com/rajbirsehmi)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
