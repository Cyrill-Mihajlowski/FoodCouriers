package com.foodcouriers.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.foodcouriers.R

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_black, FontWeight.Black)
)

object AppTypography {
    val bodySmall = 12.sp
    val bodyMedium = 14.sp
    val bodyLarge = 16.sp
    val titleSmall = 16.sp
    val titleMedium = 18.sp
    val titleLarge = 20.sp
}

object CustomStyles {
    val filterItems = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = AppTypography.titleSmall,
    )
    val menuItems = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = AppColors.Dark
    )
    val searchField = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = AppColors.Dark_2
    )
    val topAppBar = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = AppColors.Gray_2,
        lineHeight = 28.sp,
    )
    val cardRating = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = AppColors.Dark_3,
    )
    val cardPrice = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = AppColors.Pink,
    )
    val cardText = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        color = Color(0xCC9D9D9D),
    )
    val cardTitle = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        color = Color(0xFF0D0D0D),
    )
    val PopularMealCardText = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = Color(0xB36E6E6E),
    )
}