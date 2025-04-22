package com.foodcouriers.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.foodcouriers.R

@Composable
fun PopularMealsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
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
            TextButton(
                onClick = { /* TODO: обработать переход к полному меню */ }
            ) {
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
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