package com.foodcouriers.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush

object AppColors {
    val White = Color(0xFFFFFFFF)
    val Pink = Color(0xFFD61355)
    val Gray = Color(0xFF3B3B3B)
    val Dark = Color(0xFF000000)
    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFFF0F0), // Цвет в начале градиента (#FFF0F0)
            Color(0xFFFFDFDF)  // Цвет в конце градиента (#FFDFDF)
        )
    )
}

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)