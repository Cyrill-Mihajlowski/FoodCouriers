package com.foodcouriers.ui.detail_menu

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodcouriers.R
import com.foodcouriers.domain.models.ProductItems
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.components.CreateAccountContent
import com.foodcouriers.ui.components.LoginContent
import com.foodcouriers.ui.components.OnboardingSlide
import com.foodcouriers.ui.components.TopCustomButton
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.AppColors.gradientBrush_2
import com.foodcouriers.ui.theme.AppColors.gradientBrush_5
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Dimens
import com.foodcouriers.ui.theme.Poppins
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailMenuScreen(
    navController: NavHostController,
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var isSheetVisible by remember { mutableStateOf(true) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(R.drawable.bg_detail_menu),
                contentDescription = "Background",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            TopButton(navController)

        }
        if (isSheetVisible) {
            ModalBottomSheetCustom(
                coroutineScope = coroutineScope,
                modalBottomSheetState = modalBottomSheetState,
                navController = navController,
                onDismiss = { isSheetVisible = false } // Обработка закрытия
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetCustom(
    coroutineScope: CoroutineScope,
    modalBottomSheetState: SheetState,
    navController: NavHostController,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectVerticalDragGestures { _, dragAmount ->
                    // Игнорируем свайпы
                }
            }
    ) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = modalBottomSheetState,
            scrimColor = Color.Transparent, // TODO: Убираем затемнение
            containerColor = Color.White,
            dragHandle = {
                Box(
                    modifier = Modifier
                        .padding(vertical = 22.dp)
                        .width(58.dp)
                        .height(5.dp)
                        .background(
                            brush = AppColors.dragHandlegradient,
                            shape = RoundedCornerShape(8.dp)
                        )
                )
            }
        ) {
            ModalBottomSheetBody(navController = navController)
        }
    }
}

@Composable
fun ModalBottomSheetBody(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PopularButton()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconCustom(R.drawable.ic_location, gradientBrush_2)
                Spacer(modifier = Modifier.width(12.dp))
                IconCustom(R.drawable.ic_love, gradientBrush_5)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Chicken Burger\n" +
                        "Promo Pack",
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 27.sp,
                    color = Color(0xFF09051C),
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Color(0xFFFFCECE)
            Rating_Order(
                icon = R.drawable.ic_half_star,
                text = "4,8 Rating",
            )
            Rating_Order(
                icon = R.drawable.ic_pocket,
                text = "7000+ Order",
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "In a medium bowl, add ground chicken, breadcrumbs, mayonnaise, onions, parsley, garlic, paprika, salt and pepper. Use your hands to combine all the ingredients together until blended, but don't over mix.",
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    lineHeight = 22.sp,
                    color = Color(0xFF000000),
                )
            )
        }
        BottomButton(navController = navController)
    }
}

@Composable
fun PopularButton() {
    TextButton(
        onClick = { },
        modifier = Modifier
            .heightIn(min = 34.dp, max = 34.dp) // Фиксированная высота
            .background(
                brush = gradientBrush_2,
                shape = RoundedCornerShape(8.dp),
                alpha = 0.1F
            ),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier
                .height(34.dp) // Высота контента
                .padding(horizontal = 20.dp), // Горизонтальные отступы
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Popular",
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color(0xFFD61355),
                )
            )
        }
    }
}

@Composable
fun IconCustom(
    icon: Int,
    background: Brush
) {
    Box(
        modifier = Modifier
            .size(34.dp)
            .background(
                brush = background,
                shape = CircleShape,
                alpha = 0.1F
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.clickable(onClick = { }),
            painter = painterResource(icon),
            contentDescription = "ic location",
            tint = Color.Unspecified,
        )
    }
}

@Composable
fun Rating_Order(
    icon: Int,
    text: String,
) {
    Row(
        modifier = Modifier.padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .padding(end = 10.dp)
                .clickable(onClick = { }),
            painter = painterResource(icon),
            contentDescription = "ic location",
            tint = Color.Unspecified,
        )
        Text(
            text = text,
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color(0x4D3B3B3B),
            )
        )
    }
}


@Composable
fun BottomButton(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
                .background(
                    color = Color(0xFFD61355),
                    shape = RoundedCornerShape(8.dp),
                ),
            onClick = { },
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(
                top = 16.dp,
                bottom = 16.dp
            )
        ) {
            Text(
                modifier = Modifier.clickable(
                    onClick = {
                        navController.navigate(Screen.Order.route) {
                            popUpTo(Screen.Home.route) { inclusive = false }
                        }
                    }
                ),
                text = stringResource(R.string.order_bottom_button),
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFFFEFEFF)
                )
            )
        }
    }
}

@Composable
fun TopButton(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 38.dp, bottom = 12.dp)
            .clickable { navController.navigate(Screen.Home.route) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextButton(
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) { inclusive = true }
                    launchSingleTop = true
                }
            },
            modifier = Modifier
                .size(45.dp)
                .background(
                    brush = AppColors.gradientBrush_2,
                    shape = RoundedCornerShape(8.dp),
                    alpha = 0.1F
                ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_red_arrow_left),
                    contentDescription = "ic google",
                    tint = Color.Unspecified,
                )
            }
        }
    }
}