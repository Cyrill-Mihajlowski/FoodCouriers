package com.foodcouriers.data

import com.foodcouriers.R
import com.foodcouriers.domain.models.MealItems
import com.foodcouriers.domain.models.ProductItems

object AppDataMocap {
    val categories = listOf(
        R.drawable.ic_burger to "Burger",
        R.drawable.ic_pizza to "Pizza",
        R.drawable.ic_sandwich to "Sandwich"
    )

    val products = listOf(
        ProductItems(
            imageResId = R.drawable.burger_1,
            name = "Chicken Burger",
            price = "$ 20.00",
            rating = "3.8"
        ),
        ProductItems(
            imageResId = R.drawable.burger_2,
            name = "Cheese Burger",
            price = "$ 15.00",
            rating = "4.5"
        ),
        ProductItems(
            imageResId = R.drawable.burger_1,
            name = "Chicken Burger",
            price = "$ 35.00",
            rating = "4.8"
        ),
    )

    val MealMenuCards = listOf(
        MealItems(
            imageResId = R.drawable.popular_pizza,
            title = "Pepper Pizza",
            text = "5kg box of Pizza",
            price = "$15"
        ),
        MealItems(
            imageResId = R.drawable.popular_pizza,
            title = "Chiken Pizza",
            text = "3kg box of Pizza",
            price = "$13"
        ),
        MealItems(
            imageResId = R.drawable.popular_pizza,
            title = "Pepper Pizza",
            text = "6kg box of Pizza",
            price = "$18"
        ),
    )
}