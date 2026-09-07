package com.creative.uienginesampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.creative.actioncomponents.ActionComponentType
import com.creative.actioncomponents.ActionComponentsScreen
import com.creative.actioncomponents.buttons.ButtonsScreen
import com.creative.actioncomponents.fabs.FabsScreen
import com.creative.actioncomponents.iconbuttons.IconButtonsScreen
import com.creative.actioncomponents.segmented.SegmentedButtonsScreen
import com.creative.core.ui.theme.UIEngineSampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIEngineSampleAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "main",
                    enterTransition = {
                        slideIntoContainer(
                            towards = AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )
                    },
                    exitTransition = {
                        slideOutOfContainer(
                            towards = AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )
                    },
                    popEnterTransition = {
                        slideIntoContainer(
                            towards = AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    },
                    popExitTransition = {
                        slideOutOfContainer(
                            towards = AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    }
                ) {
                    composable("main") {
                        MainScreen(
                            onCategoryClick = { category ->
                                if (category.name == "Action Components") {
                                    navController.navigate("action_components")
                                }
                            }
                        )
                    }
                    composable("action_components") {
                        ActionComponentsScreen(
                            onNavigate = { type ->
                                when (type) {
                                    ActionComponentType.BUTTONS -> navController.navigate("buttons")
                                    ActionComponentType.FABS -> navController.navigate("fabs")
                                    ActionComponentType.ICON_BUTTONS -> navController.navigate("icon_buttons")
                                    ActionComponentType.SEGMENTED -> navController.navigate("segmented")
                                }
                            },
                            onBack = { navController.popBackStack() }
                        )
                    }
                    composable("buttons") { ButtonsScreen(onBack = { navController.popBackStack() }) }
                    composable("fabs") { FabsScreen(onBack = { navController.popBackStack() }) }
                    composable("icon_buttons") { IconButtonsScreen(onBack = { navController.popBackStack() }) }
                    composable("segmented") { SegmentedButtonsScreen(onBack = { navController.popBackStack() }) }
                }
            }
        }
    }
}

data class Category(
    val name: String,
    val description: String,
    val icon: ImageVector,
    val gradient: List<Color>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onCategoryClick: (Category) -> Unit) {
    val categories = listOf(
        Category("Action Components", "Buttons, FABs, and clickables", Icons.Default.PlayArrow, listOf(Color(0xFF6750A4), Color(0xFFD0BCFF))),
        Category("Text & Input", "TextFields, Switches, Forms", Icons.Default.Edit, listOf(Color(0xFF006A6A), Color(0xFF4EE8E8))),
        Category("Structure", "Cards, Sheets, and Lists", Icons.Default.List, listOf(Color(0xFF7D5260), Color(0xFFEFB8C8))),
        Category("Navigation", "Bars, Rails, and Drawers", Icons.Default.Menu, listOf(Color(0xFF6750A4), Color(0xFF006A6A))),
        Category("Feedback", "Snackbars, Dialogs, Progress", Icons.Default.Notifications, listOf(Color(0xFF006A6A), Color(0xFF7D5260))),
        Category("Layout", "Box, Column, Row, Scaffold", Icons.Default.Build, listOf(Color(0xFF7D5260), Color(0xFF6750A4)))
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "UI Engine",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(
                        Brush.linearGradient(
                            listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary)
                        )
                    )
                    .padding(24.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column {
                    Text(
                        "Design System",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                    Text(
                        "Master the Components",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Black
                    )
                }
            }

            Text(
                text = "Components Library",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 8.dp)
            )

            categories.forEach { category ->
                CategoryCard(category, onClick = { onCategoryClick(category) })
            }
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(category: Category, onClick: () -> Unit) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Brush.linearGradient(category.gradient)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = category.icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = category.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.outline,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    UIEngineSampleAppTheme {
        MainScreen(onCategoryClick = {})
    }
}
