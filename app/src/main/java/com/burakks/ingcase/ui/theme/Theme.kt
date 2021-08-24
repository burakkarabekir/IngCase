package com.burakks.ingcase.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//private val DarkColorPalette = darkColors(
//    primary = BlueAccent,
//    background = DarkGray,
//    onBackground = TextWhite,
//    onPrimary = DarkGray,
//    surface = MediumGray,
//    onSurface = LightGray
//)

private val LightColorPalette = lightColors(
    primary = BlueAccent,
    background = Color.White,
    onBackground = TextWhite,
    onPrimary = DarkGray,
    surface = MediumGray,
    onSurface = LightGray
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit) {
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}