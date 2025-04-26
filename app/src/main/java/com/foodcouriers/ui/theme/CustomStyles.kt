package com.foodcouriers.ui.theme

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

object CustomStyles {
    val filterItems = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
//        lineHeight = 36.sp,
//        color = AppColors.White
    )
    val menuItems = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = AppColors.Dark
//        lineHeight = 36.sp,
    )

    val searchField = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = AppColors.Dark_2
//        lineHeight = 36.sp,
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
//        lineHeight = 28.sp,
    )

    val cardPrice = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = AppColors.Pink,
//        lineHeight = 28.sp,
    )

    val cardText = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        color = Color(0xCC9D9D9D),
//        lineHeight = 28.sp,
    )

    val cardTitle = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        color = Color(0xFF0D0D0D),
//        lineHeight = 28.sp,
    )

    val PopularMealCardText = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = Color(0xB36E6E6E),
//        lineHeight = 28.sp,
    )
}