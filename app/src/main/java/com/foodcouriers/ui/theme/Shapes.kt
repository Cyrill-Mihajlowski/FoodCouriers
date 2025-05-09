package com.foodcouriers.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

@Immutable
object AppShapes {
    // Маленькие закругления (кнопки, чипы)
    val small = RoundedCornerShape(4.dp)

    // Средние закругления (карточки)
    val medium = RoundedCornerShape(8.dp)
    // Большие закругления (модальные окна)
    val large = RoundedCornerShape(16.dp)

    // Полностью круглая форма (иконки)
    val circle = RoundedCornerShape(percent = 50)

    // Кастомная форма с разными радиусами
    val customDialog = RoundedCornerShape(
        topStart = 12.dp,
        topEnd = 12.dp,
        bottomEnd = 4.dp,
        bottomStart = 4.dp
    )
}