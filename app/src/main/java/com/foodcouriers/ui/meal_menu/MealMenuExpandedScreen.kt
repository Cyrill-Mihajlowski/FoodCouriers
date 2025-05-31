package com.foodcouriers.ui.meal_menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.foodcouriers.R
import com.foodcouriers.ui.components.BottomNavigationBar
import com.foodcouriers.ui.components.TopCustomButton
import com.foodcouriers.ui.home.HomeMockData
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Dimens
import com.foodcouriers.ui.theme.Roboto

@Composable
fun MealMenuExpandedScreen(navController: NavHostController) {
    val products = HomeMockData.mealMenuCards()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFEFEFF)),
        ) {
            Image(
                painter = painterResource(R.drawable.background_1),
                contentDescription = "Background",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                TopButtons(navController = navController)
                Title()
                Input()

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 26.dp)
                ) {
                    item {
                        products.forEach { product ->
                            MealCard(
                                imageResId = product.imageResId,
                                title = product.title,
                                text = product.text,
                                price = product.price,
                                onClick = { /* TODO: обработать клик по карточке */ }
                            )
                        }
                        products.forEach { product ->
                            MealCard(
                                imageResId = product.imageResId,
                                title = product.title,
                                text = product.text,
                                price = product.price,
                                onClick = { /* TODO: обработать клик по карточке */ }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Title() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = stringResource(R.string.meal_menu_title),
            style = CustomStyles.Order_title
        )
    }
}

@Composable
fun TopButtons(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(top = 20.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TopCustomButton(
            icon = R.drawable.ic_red_arrow_left,
            click = { navController.popBackStack() }
        )
        TopCustomButton(
            icon = R.drawable.ic_notifiaction,
            click = {}
        )
    }
}

@Composable
fun Input() {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFFF0F0),
            Color(0xFFFFDFDF)
        )
    )

    val searchQuery = remember { mutableStateOf("") }

    BasicTextField(
        value = searchQuery.value,
        onValueChange = { searchQuery.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(top = 8.dp, bottom = 28.dp)
            .height(36.dp)
            .background(
                brush = gradientBrush,
                shape = RoundedCornerShape(8.dp)
            ),

        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(Dimens.ExtraLargePadding))
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable(onClick = { }),
                    tint = AppColors.Dark
                )
                Spacer(modifier = Modifier.width(Dimens.Medium3Padding))
                if (searchQuery.value.isEmpty()) {
                    Text(
                        text = stringResource(R.string.meal_menu_input_title),
                        style = TextStyle(
                            fontFamily = Roboto,
                            fontWeight = FontWeight.Black,
                            fontSize = 12.sp,
                            color = Color(0xFF000000),
                        ),
                    )
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    innerTextField()
                }
            }
        }
    )
}

@Composable
fun MealCard(
    imageResId: Int,
    title: String,
    text: String,
    price: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .background(AppColors.White)
                .padding(8.dp)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = text,
                    style = CustomStyles.PopularMealCardText,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = price,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(end = 12.dp)
            )
        }
    }
}