package com.foodcouriers.ui.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.foodcouriers.domain.models.OrderCardItems
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.components.AppLayout
import com.foodcouriers.ui.components.CustomButton
import com.foodcouriers.ui.components.TopBar
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.AppColors.gradientBrush_2
import com.foodcouriers.ui.theme.AppColors.gradientBrush_3
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Poppins
import com.foodcouriers.ui.theme.Roboto

@Composable
fun OrderScreen(navController: NavHostController) {
    val array = listOf(
        OrderCardItems(
            imageResId = R.drawable.popular_pizza,
            title = "Chicken Burger",
            text = "Burger Factory LTD",
            price = "15"
        ),
        OrderCardItems(
            imageResId = R.drawable.popular_pizza,
            title = "Chicken Burger",
            text = "Burger Factory LTD",
            price = "15"
        ),
        OrderCardItems(
            imageResId = R.drawable.popular_pizza,
            title = "Chicken Burger",
            text = "Burger Factory LTD",
            price = "15"
        ),
    )
    val array_2 = mapOf(
        stringResource(R.string.order_card_title_1) to "100",
        stringResource(R.string.order_card_title_2) to "10",
        stringResource(R.string.order_card_title_3) to "100",
        stringResource(R.string.order_card_title_4) to "110",
    )

    val topBarIcons = mapOf<Int, () -> Unit>(
        R.drawable.ic_red_arrow_left to { navController.popBackStack() },
    )

    AppLayout(
        topBar = { TopBar(topBarIcons) },
        contentPadding = PaddingValues(horizontal = 24.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 22.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = stringResource(R.string.order_title_order_detail),
                            style = CustomStyles.Order_title
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        array.forEach { item ->
                            OrderCustomCard(
                                imageResId = item.imageResId,
                                title = item.title,
                                text = item.text,
                                price = item.price,
                            )
                        }
                    }
                }
            }
            OrderPayBox(
                array = array_2,
                navController = navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
        }
    }
}

@Composable
fun OrderPayBox(
    array: Map<String, String>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val items = array.toList()

    Box(
        modifier = modifier
            .background(
                brush = gradientBrush_2,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 206.dp)
                .padding(top = 20.dp, start = 29.dp, end = 29.dp),
        ) {
            items.forEachIndexed { index, (title, price) ->
                val isLastItem = index == items.lastIndex

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = if (isLastItem) 14.dp else 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontFamily = if (isLastItem) Roboto else Poppins,
                            fontWeight = if (isLastItem) FontWeight.Black else FontWeight.Medium,
                            fontSize = if (isLastItem) 18.sp else 14.sp,
                            color = Color(0xFFFEFEFF),
                        )
                    )
                    Text(
                        text = "$price $",
                        style = TextStyle(
                            fontFamily = if (isLastItem) Roboto else Poppins,
                            fontWeight = if (isLastItem) FontWeight.Black else FontWeight.Medium,
                            fontSize = if (isLastItem) 18.sp else 14.sp,
                            color = Color(0xFFFEFEFF),
                        )
                    )
                }
            }
        }

        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp)
                .padding(bottom = 12.dp)
                .background(
                    color = Color(0xFFFEFEFF),
                    shape = RoundedCornerShape(8.dp),
                ),
            text = stringResource(R.string.order_bottom_button),
            textStyle = TextStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                brush = gradientBrush_2,
            ),
            onClick = { navController.navigate(Screen.FinishOrder.route) }
        )
    }
}

@Composable
fun OrderCustomCard(
    imageResId: Int,
    title: String,
    text: String,
    price: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier
                .background(AppColors.White)
                .padding(8.dp)
                .clickable { },
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
                Text(
                    text = "$ ${price}",
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp,
                        brush = gradientBrush_2
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                modifier = Modifier.padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OrderCustomIcon(
                    imageResId = R.drawable.ic_order_button_minus,
                    brush = gradientBrush_3,
                    onClick = { }
                )

                Text(
                    text = "1",
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = Color(0xFF181818)
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                OrderCustomIcon(
                    imageResId = R.drawable.ic_order_button_plus,
                    brush = gradientBrush_2,
                    onClick = { }
                )
            }
        }
    }
}

@Composable
fun OrderCustomIcon(
    imageResId: Int,
    brush: Brush,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(26.dp)
            .background(
                brush = brush,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = imageResId),
            contentDescription = "Icon",
            modifier = Modifier.size(10.dp),
            tint = Color.Unspecified
        )
    }
}