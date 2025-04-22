package com.foodcouriers.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// TODO: Mockup Scheme
private val DarkColorScheme = darkColorScheme(
    primary = AppColors.Dark,
    background = AppColors.Dark,
    onBackground = AppColors.Dark
)

private val LightColorScheme = lightColorScheme(
    primary = AppColors.Pink,
    background = AppColors.White,
)

@Composable
fun FoodCouriersTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}