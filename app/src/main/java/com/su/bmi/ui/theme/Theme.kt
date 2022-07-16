package com.su.bmi.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


@SuppressLint("ConflictingOnColor")
private val LightThemeColors = lightColors(
    primary = backgroundColor,
    primaryVariant = foregroundColor,
    onPrimary = foregroundColor,
    secondary = backgroundColor,
    secondaryVariant = backgroundColor,
    background = backgroundColor,
    onSecondary = foregroundColor,
    error = Red800
)

private val DarkThemeColors = darkColors(
    primary = Red300,
    primaryVariant = Red700,
    secondary = Red300,
    error = Red200
)

@Composable
fun BMITheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkThemeColors
    } else {
        LightThemeColors
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}