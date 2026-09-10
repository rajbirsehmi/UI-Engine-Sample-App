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
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.creative.uienginesampleapp.action_components.ButtonShowcase
import com.creative.uienginesampleapp.action_components.FabShowcase
import com.creative.uienginesampleapp.action_components.IconButtonShowcase
import com.creative.uienginesampleapp.action_components.SegmentedButtonShowcase
import com.creative.uienginesampleapp.text_input_components.SelectionControlsShowcase
import com.creative.uienginesampleapp.text_input_components.SliderShowcase
import com.creative.uienginesampleapp.text_input_components.TextFieldShowcase
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

data class Category(
    val name: String,
    val description: String,
    val icon: ImageVector
)

sealed class Screen {
    object Main : Screen()
    object ActionComponents : Screen()
    object Buttons : Screen()
    object FABs : Screen()
    object IconButtons : Screen()
    object SegmentedButtons : Screen()
    object TextInputControls : Screen()
    object TextFields : Screen()
    object SelectionControls : Screen()
    object Sliders : Screen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Main) }

    val categories = listOf(
        Category("Action Components", "Buttons, FABs, and clickables", Icons.Default.PlayArrow),
        Category("Text & Input Controls", "TextFields, Switches, and Forms", Icons.Default.Edit),
        Category("Containment & Structure", "Cards, Sheets, and Lists", Icons.AutoMirrored.Filled.List),
        Category("Navigation Components", "Bars, Rails, and Drawers", Icons.Default.Menu),
        Category("Communication & Feedback", "Snackbars, Dialogs, and Progress", Icons.Default.Notifications),
        Category("Layout Containers", "Box, Column, Row, and Scaffold", Icons.Default.Build)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.testTag("top_app_bar"),
                title = {
                    Text(
                        when (currentScreen) {
                            Screen.Main -> "UI Engine Sample App"
                            Screen.ActionComponents -> "Action Components"
                            Screen.Buttons -> "Buttons"
                            Screen.FABs -> "FABs"
                            Screen.IconButtons -> "Icon Buttons"
                            Screen.SegmentedButtons -> "Segmented Buttons"
                            Screen.TextInputControls -> "Text & Input Controls"
                            Screen.TextFields -> "Text Fields"
                            Screen.SelectionControls -> "Selection Controls"
                            Screen.Sliders -> "Sliders"
                        },
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.testTag("screen_title")
                    )
                },
                navigationIcon = {
                    if (currentScreen != Screen.Main) {
                        IconButton(
                            onClick = {
                                currentScreen = when (currentScreen) {
                                    Screen.Buttons, Screen.FABs, Screen.IconButtons, Screen.SegmentedButtons -> Screen.ActionComponents
                                    Screen.TextFields, Screen.SelectionControls, Screen.Sliders -> Screen.TextInputControls
                                    else -> Screen.Main
                                }
                            },
                            modifier = Modifier.testTag("back_button")
                        ) {
                            Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.surface
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when (currentScreen) {
                Screen.Main -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Welcome to UI Engine Sample App",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Explore the building blocks of modern Android interfaces.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        categories.forEach { category ->
                            CategoryCard(
                                category,
                                onClick = {
                                    currentScreen = when (category.name) {
                                        "Action Components" -> Screen.ActionComponents
                                        "Text & Input Controls" -> Screen.TextInputControls
                                        else -> Screen.Main
                                    }
                                },
                                modifier = Modifier.testTag("category_${category.name.replace(" ", "_").lowercase()}")
                            )
                        }
                    }
                }
                Screen.ActionComponents -> {
                    ActionComponentsList(onComponentClick = { screen ->
                        currentScreen = screen
                    })
                }
                Screen.TextInputControls -> {
                    TextInputComponentsList(onComponentClick = { screen ->
                        currentScreen = screen
                    })
                }
                Screen.Buttons -> ButtonShowcase()
                Screen.FABs -> FabShowcase()
                Screen.IconButtons -> IconButtonShowcase()
                Screen.SegmentedButtons -> SegmentedButtonShowcase()
                Screen.TextFields -> TextFieldShowcase()
                Screen.SelectionControls -> SelectionControlsShowcase()
                Screen.Sliders -> SliderShowcase()
            }
        }
    }
}

@Composable
fun TextInputComponentsList(onComponentClick: (Screen) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .testTag("text_input_components_list"),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val components = listOf(
            "Text Fields" to Screen.TextFields,
            "Selection Controls" to Screen.SelectionControls,
            "Sliders" to Screen.Sliders
        )

        components.forEach { (name, screen) ->
            ElevatedCard(
                onClick = { onComponentClick(screen) },
                modifier = Modifier.fillMaxWidth()
            ) {
                ListItem(
                    headlineContent = { Text(name) },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun ActionComponentsList(onComponentClick: (Screen) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .testTag("action_components_list"),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val components = listOf(
            "Buttons" to Screen.Buttons,
            "FABs" to Screen.FABs,
            "Icon Buttons" to Screen.IconButtons,
            "Segmented Buttons" to Screen.SegmentedButtons
        )

        components.forEach { (name, screen) ->
            ElevatedCard(
                onClick = { onComponentClick(screen) },
                modifier = Modifier.fillMaxWidth()
            ) {
                ListItem(
                    headlineContent = { Text(name) },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(category: Category, onClick: () -> Unit, modifier: Modifier = Modifier) {
    ElevatedCard(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        ListItem(
            headlineContent = {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            },
            supportingContent = {
                Text(
                    text = category.description,
                    style = MaterialTheme.typography.bodySmall
                )
            },
            leadingContent = {
                Icon(
                    imageVector = category.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.outline
                )
            },
            colors = ListItemDefaults.colors(
                containerColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    UIEngineSampleAppTheme {
        MainScreen()
    }
}
