package com.foodcouriers.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    val images = listOf(
        R.drawable.image_1,
        R.drawable.image_1,
        R.drawable.image_1
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        HomeTopBar()
        Spacer(modifier = Modifier.height(4.dp))
        SearchField()
        Spacer(modifier = Modifier.height(4.dp))
        ImageCarousel(
            images = listOf(R.drawable.image_1, R.drawable.burger_1, R.drawable.image_1) // Добавить нужное изображение
        )
        Spacer(modifier = Modifier.height(4.dp))
        HomeFilters(
            categories = categories,
            selectedCategoryIndex = selectedCategoryIndex.value,
            onCategorySelected = { selectedCategoryIndex.value = it }
        )
//        Spacer(modifier = Modifier.height(4.dp))
        ProductsList()
        Spacer(modifier = Modifier.height(4.dp))
        PopularMealsSection()
    }
}