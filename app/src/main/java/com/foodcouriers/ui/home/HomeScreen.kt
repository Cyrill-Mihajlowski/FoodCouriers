package com.foodcouriers.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.foodcouriers.R
import com.foodcouriers.ui.components.HomeFilters
import com.foodcouriers.ui.components.HomeTopBar
import com.foodcouriers.ui.components.ImageCarousel
import com.foodcouriers.ui.components.PopularMealsSection
import com.foodcouriers.ui.components.ProductsList
import com.foodcouriers.ui.components.SearchField

@Composable
fun HomeScreen() {
    val categories = listOf(
        R.drawable.ic_burger to "Burger",
        R.drawable.ic_pizza to "Pizza",
        R.drawable.ic_sandwich to "Sandwich"
    )
    var selectedCategoryIndex = remember { mutableStateOf(0) }

    Scaffold(
        topBar = { HomeTopBar() }
    ) { content_padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(content_padding)
        ) {
            SearchField()
            ImageCarousel()
            HomeFilters(
                categories = categories,
                selectedCategoryIndex = selectedCategoryIndex.value,
                onCategorySelected = { selectedCategoryIndex.value = it }
            )
            ProductsList()
            PopularMealsSection()
        }
    }
}