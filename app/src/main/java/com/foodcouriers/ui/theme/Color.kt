package com.foodcouriers.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush

object AppColors {
    val White = Color(0xFFFFFFFF)
    val White_2 = Color(0xFFF7F9FF)
    val Pink = Color(0xFFD61355)
    val Pink_2 = Color(0xFFFFF0F0)
    val Pink_3 = Color(0xFFFF0000)
    val Gray = Color(0xFF3B3B3B)
    val Gray_2 = Color(0xFF4B5563)
    val Gray_3 = Color(0xFFE2E2E2)
    val Dark = Color(0xFF000000)
    val Dark_2 = Color(0x80000000)
    val Dark_3 = Color(0xFF0D0D0D)
    val Yellow = Color(0xFFEEFF32)
    val Transparent = Color(0x00FFFFFF)
    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFFF0F0), // Цвет в начале градиента (#FFF0F0)
            Color(0xFFFFDFDF)  // Цвет в конце градиента (#FFDFDF)
        )
    )
    val gradientBrush_2 = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFD61355),
            Color(0xFFFF0000)
        )
    )
    val gradientBrush_3 = Brush.horizontalGradient(
        colors = listOf(
            Color(0x1AD61355),
            Color(0x1AFF0000)
        )
    )

    val gradientBrush_4 = Brush.horizontalGradient(
        colors = listOf(
            Color(0x1AF6F6F6),
            Color(0xFFF6F6F6)
        )
    )

    val gradientBrush_5 = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF000000),
            Color(0xFF000000)
        )
    )

    val dragHandlegradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFFF0F0),
            Color(0xFFFFDFDF)
        )
    )
}