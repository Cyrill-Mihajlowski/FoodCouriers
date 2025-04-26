package com.foodcouriers.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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

    Scaffold(
        topBar = { HomeTopBar() },
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.pattern),
                contentDescription = "Background",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .height(200.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp)
                    .padding(padding)
                    .padding(bottom = 70.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    SearchField()
                    Spacer(modifier = Modifier.height(4.dp))
                    ImageCarousel(
                        images = listOf(
                            R.drawable.burger_1,
                            R.drawable.burger_1,
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    HomeFilters(
                        categories = categories,
                        selectedCategoryIndex = selectedCategoryIndex.value,
                        onCategorySelected = { selectedCategoryIndex.value = it }
                    )
                    ProductsList()
                    Spacer(modifier = Modifier.height(4.dp))
                    PopularMealsSection()
                }
            }
        }
    }
}