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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.foodcouriers.R
import com.foodcouriers.ui.components.BottomNavigationBar
import com.foodcouriers.ui.components.HomeFilters
import com.foodcouriers.ui.components.HomeTopBar
import com.foodcouriers.ui.components.HomeCarousel
import com.foodcouriers.ui.components.HomeMenuList
import com.foodcouriers.ui.components.HomeFiltersCard
import com.foodcouriers.ui.components.HomeSearchBar

@Composable
fun HomeScreen(navController: NavHostController) {
    val categories = HomeMockData.categories()
    val featuredProducts = HomeMockData.featuredProducts()
    val mealMenuCards = HomeMockData.mealMenuCards()

    var selectedCategoryIndex = remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = { HomeTopBar(navController = navController) },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }) { padding ->
        Box(
            modifier = Modifier.fillMaxSize()
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
                    .padding(padding)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    HomeSearchBar()
                    HomeCarousel(
                        listOf(
                            R.drawable.pc_carusel,
                            R.drawable.pc_carusel,
                            R.drawable.pc_carusel,
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    HomeFilters(
                        categories = categories,
                        selectedCategoryIndex = selectedCategoryIndex.intValue,
                        onCategorySelected = { selectedCategoryIndex.intValue = it })
                    HomeFiltersCard(products = featuredProducts, navController = navController)
                    Spacer(modifier = Modifier.height(4.dp))
                    HomeMenuList(products = mealMenuCards, navController = navController)
                }
            }
        }
    }
}