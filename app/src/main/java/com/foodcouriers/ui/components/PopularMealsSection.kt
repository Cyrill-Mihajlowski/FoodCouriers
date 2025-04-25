package com.foodcouriers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.foodcouriers.R
import com.foodcouriers.ui.theme.AppColors

@Composable
fun PopularMealsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Popular Meal Menu",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = { /* TODO: обработать переход к полному меню */ },
                ) {
                    Text(
                        text = "See All",
                        style = MaterialTheme.typography.labelSmall,
                        color = AppColors.Dark_2
                    )
                }
                Image(
                    painter = painterResource(R.drawable.ic_right_arrow),
                    contentDescription = "arrow",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(12.dp)
                )
            }

        }
        PopularMealCard(
            imageResId = R.drawable.popular_pizza,
            name = "Pepper Pizza",
            description = "5kg box of Pizza",
            price = "$15",
            onClick = { /* TODO: обработать клик по карточке */ }
        )
    }
}