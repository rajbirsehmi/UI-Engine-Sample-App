package com.creative.uienginesampleapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = PremiumPrimaryDark,
    secondary = PremiumSecondaryDark,
    background = PremiumBackgroundDark,
    surface = PremiumSurfaceDark,
    onPrimary = PremiumBackgroundDark,
    onSecondary = PremiumBackgroundDark,
    onBackground = PremiumBackgroundLight,
    onSurface = PremiumBackgroundLight
)

private val LightColorScheme = lightColorScheme(
    primary = PremiumPrimaryLight,
    secondary = PremiumSecondaryLight,
    background = PremiumBackgroundLight,
    surface = PremiumSurfaceLight,
    onPrimary = PremiumSurfaceLight,
    onSecondary = PremiumSurfaceLight,
    onBackground = PremiumBackgroundDark,
    onSurface = PremiumBackgroundDark
)

@Composable
fun UIEngineSampleAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
