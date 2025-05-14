package com.foodcouriers.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.foodcouriers.ui.components.AppLayout
import com.foodcouriers.ui.components.BottomNavigationBar
import com.foodcouriers.ui.components.HomeCarousel
import com.foodcouriers.ui.components.HomeFilters
import com.foodcouriers.ui.components.HomeFiltersCard
import com.foodcouriers.ui.components.HomeMenuList
import com.foodcouriers.ui.components.HomeSearchBar
import com.foodcouriers.ui.components.HomeTopBar

@Composable
fun HomeScreen(navController: NavHostController) {
    val categories = HomeMockData.categories()
    val featuredProducts = HomeMockData.featuredProducts()
    val mealMenuCards = HomeMockData.mealMenuCards()
    val imageList = HomeMockData.imageList

    var selectedCategoryIndex = remember { mutableIntStateOf(0) }

    AppLayout(
        topBar = { HomeTopBar(navController = navController) },
        bottomBar = { BottomNavigationBar(navController) },
        contentPadding = PaddingValues(10.dp),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                HomeSearchBar()
                HomeCarousel(imageList = imageList)
                Spacer(modifier = Modifier.height(4.dp))
                HomeFilters(
                    categories = categories,
                    selectedCategoryIndex = selectedCategoryIndex.intValue,
                    onCategorySelected = { selectedCategoryIndex.intValue = it }
                )
                HomeFiltersCard(
                    products = featuredProducts,
                    navController = navController
                )
                Spacer(modifier = Modifier.height(4.dp))
                HomeMenuList(
                    products = mealMenuCards,
                    navController = navController
                )
            }
        }
    }
}