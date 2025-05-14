package com.foodcouriers.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.foodcouriers.R
import com.foodcouriers.domain.models.MealItems
import com.foodcouriers.domain.models.ProductItems

object HomeMockData {
    @Composable
    fun categories(): List<Pair<Int, String>> {
        return listOf(
            R.drawable.ic_burger to stringResource(R.string.category_burger),
            R.drawable.ic_pizza to stringResource(R.string.category_pizza),
            R.drawable.ic_sandwich to stringResource(R.string.category_sandwich)
        )
    }

    fun featuredProducts(): List<ProductItems> {
        return listOf(
            ProductItems(
                id = "1",
                imageResId = R.drawable.burger_1,
                name = "Chicken Burger",
                price = "$20.00",
                rating = "4.5",
                description = "100 gr chicken + tomato + cheese  Lettuce"
            ),
            ProductItems(
                id = "2",
                imageResId = R.drawable.burger_2,
                name = "Cheese Burger",
                price = "$18.00",
                rating = "4.8",
                description = "100 gr chicken + tomato + cheese  Lettuce"
            ),
            ProductItems(
                id = "3",
                imageResId = R.drawable.burger_1,
                name = "Chicken Burger",
                price = "$ 35.00",
                rating = "4.8",
                description = "100 gr chicken + tomato + cheese  Lettuce"
            ),
        )
    }

    fun mealMenuCards(): List<MealItems> {
        return listOf(
            MealItems(
                imageResId = R.drawable.popular_pizza,
                title = "Pepper Pizza",
                text = "4kg box of Pizza",
                price = "$15"
            ),
            MealItems(
                imageResId = R.drawable.popular_pizza_2,
                title = "Chicken Burger",
                text = "3kg box of Pizza",
                price = "$20"
            ),
            MealItems(
                imageResId = R.drawable.popular_pizza_3,
                title = "Onion Pizza",
                text = "3kg box of Pizza",
                price = "$17"
            ),
        )
    }

    val imageList: List<Int> = listOf(
        R.drawable.pc_carusel,
        R.drawable.pc_carusel,
        R.drawable.pc_carusel,
    )
}