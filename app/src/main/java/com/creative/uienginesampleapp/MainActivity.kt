package com.creative.uienginesampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.creative.uienginesampleapp.ui.theme.UIEngineSampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIEngineSampleAppTheme {
                MainScreen()
            }
        }
    }
}

sealed class Screen(val title: String) {
    object Main : Screen("UiTestEngine Showcase")
    object Gestures : Screen("Gestures")
    object TextInput : Screen("Text Input")
    object Scrolling : Screen("Scrolling")
    object System : Screen("System")
    object Accessibility : Screen("Accessibility")
}

data class TestCategory(
    val name: String,
    val description: String,
    val icon: ImageVector,
    val screen: Screen
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Main) }

    val categories = listOf(
        TestCategory("Gestures", "Click, Tap, Long Press, Drag, Zoom, Rotate", Icons.Default.TouchApp, Screen.Gestures),
        TestCategory("Text Input", "Enter, Replace, Clear, IME, Focus", Icons.Default.Edit, Screen.TextInput),
        TestCategory("Scrolling", "Tag, Index, Key, SwipeUntilVisible", Icons.Default.List, Screen.Scrolling),
        TestCategory("System", "Back, Home, Permission, Notifications", Icons.Default.Settings, Screen.System),
        TestCategory("Accessibility", "Focus Order, Labels, Traversal", Icons.Default.Accessibility, Screen.Accessibility)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = currentScreen.title,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.testTag("screen_title")
                    )
                },
                navigationIcon = {
                    if (currentScreen != Screen.Main) {
                        IconButton(
                            onClick = { currentScreen = Screen.Main },
                            modifier = Modifier.testTag("back_button")
                        ) {
                            Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                modifier = Modifier.testTag("top_app_bar")
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when (currentScreen) {
                Screen.Main -> MainDashboard(categories) { currentScreen = it }
                Screen.Gestures -> GesturesScreen()
                Screen.TextInput -> TextInputScreen()
                Screen.Scrolling -> ScrollingScreen()
                Screen.System -> SystemScreen()
                Screen.Accessibility -> AccessibilityScreen()
            }
        }
    }
}

@Composable
fun MainDashboard(categories: List<TestCategory>, onNavigate: (Screen) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .testTag("main_dashboard"),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        categories.forEach { category ->
            ElevatedCard(
                onClick = { onNavigate(category.screen) },
                modifier = Modifier.fillMaxWidth().testTag("category_${category.name.lowercase().replace(" ", "_")}")
            ) {
                ListItem(
                    headlineContent = { Text(category.name, fontWeight = FontWeight.Bold) },
                    supportingContent = { Text(category.description) },
                    leadingContent = { Icon(category.icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary) },
                    trailingContent = { Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null) },
                    colors = ListItemDefaults.colors(containerColor = Color.Transparent)
                )
            }
        }
    }
}
