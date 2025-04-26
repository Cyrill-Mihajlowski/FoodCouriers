package com.foodcouriers.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.foodcouriers.R
import com.foodcouriers.domain.models.ProductItems

@Composable
fun ProductsList() {
    val products = listOf(
        ProductItems(imageResId = R.drawable.burger_1, name = "Chicken Burger", price = "$ 20.00", rating = "3.8"),
        ProductItems(imageResId = R.drawable.burger_2, name = "Cheese Burger", price = "$ 15.00", rating = "4.5"),
        ProductItems(imageResId = R.drawable.burger_1, name = "Chicken Burger", price = "$ 35.00", rating = "4.8"),
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        items(products) { product ->
            ProductCard(
                imageResId = product.imageResId,
                name = product.name,
                rating = product.rating,
                price = product.price,
                description = "100 gr chicken + tomato + cheese  Lettuce",
                onAddToCart = { /* TODO: добавить логику добавления в корзину */ }
            )
        }
    }
}