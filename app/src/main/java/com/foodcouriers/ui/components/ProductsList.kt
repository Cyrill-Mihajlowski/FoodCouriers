package com.foodcouriers.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.foodcouriers.R

@Composable
fun ProductsList() {
    val products = listOf(
        Triple(R.drawable.burger_1, "Chicken Burger", "$20.00"),
        Triple(R.drawable.burger_2, "Cheese Burger", "$15.00")
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items(products) { product ->
            ProductCard(
                imageResId = product.first,
                name = product.second,
                description = "100 gr chicken + tomato + cheese + lettuce",
                price = product.third,
                onAddToCart = { /* TODO: добавить логику добавления в корзину */ }
            )
        }
    }
}