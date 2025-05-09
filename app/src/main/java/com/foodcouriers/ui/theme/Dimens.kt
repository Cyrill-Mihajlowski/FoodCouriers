package com.foodcouriers.ui.theme

import androidx.compose.ui.unit.dp
import kotlin.math.round

// TODO: Эти размеры получены исходя из макета Figma где frame равен 375х812

object Dimens {
    private const val density = 1f // Плотность экрана (коэффициент 1)

    val SmallPadding =  round(4 / density).toInt().dp
    val MediumPadding = round(8 / density).toInt().dp
    val Medium2Padding = round(12 / density).toInt().dp
    val Medium3Padding = round(10 / density).toInt().dp
    val LargePadding = round(16 / density).toInt().dp
    val Large2Padding = round(25 / density).toInt().dp
    val Large3Padding = round(28 / density).toInt().dp
    val ExtraLargePadding = round(32 / density).toInt().dp
}