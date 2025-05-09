package com.foodcouriers.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import com.foodcouriers.R

// TODO: FontWeight соответствует:
// TODO: Thin - 100, Light - 300, Normal (Regular) - 400, Medium - 500
// TODO: W600 (SemiBold) - 600 (кастомное значение), Bold - 700, Black - 900

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_black, FontWeight.Black)
)

val Roboto = FontFamily(
    // Тонкое начертание (Thin)
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_thin_italic, FontWeight.Thin, FontStyle.Italic),
    // Светлое начертание (Light)
    Font(R.font.roboto_light, FontWeight.Light),
    // Обычное начертание (Regular)
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),
    // Среднее начертание (Medium)
    Font(R.font.roboto_medium, FontWeight.Medium),
    // Полужирное (SemiBold - используем кастомный вес)
    Font(R.font.roboto_semibold, FontWeight.W600),
    // Жирное (Bold)
    Font(R.font.roboto_bold, FontWeight.Bold),
    // Черное (Black)
    Font(R.font.roboto_black, FontWeight.Black),
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
        color = AppColors.Dark_2,
        lineHeight = 8.sp,
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
    val OnboardTitle = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = Color(0xFF000000),
    )
    val OnboardText = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color(0xFF595959),
    )
    val OnboardButton = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Black,
        fontSize = 16.sp,
        color = Color(0xFFFFFFFF),
    )
    val OnboardButtonSkip = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color(0xFF000000),
    )
    val OnboardLogin = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color(0xFF3B3B3B),
    )
    val OnboardInput = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFF000000),
    )
    val OnboardInputItems = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFF3B3B3B),
    )
    val OboardButtonRed = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Black,
        fontSize = 14.sp,
        color = Color(0xFFFFFFFF),
    )
    val OnboardSighuporLoginwith = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Color(0xFF000000),
    )
    val OnboardTab = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color(0xFFD61355),
    )

    val Profile_title = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        color = Color(0xFF000000),
    )

    val Profile_title_2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color(0xFF000000),
    )

    val Profile_title_3 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFF3B3B3B),
    )

    val Profile_title_item = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFF000000),
    )

    val Order_title = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        color = Color(0xFF000000),
    )

    val Chat_title = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        color = Color(0xFF000000),
    )
}