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
import androidx.navigation.NavHostController
import com.foodcouriers.R
import com.foodcouriers.data.AppDataMocap
import com.foodcouriers.ui.components.BottomNavigationBar
import com.foodcouriers.ui.components.HomeFilters
import com.foodcouriers.ui.components.HomeTopBar
import com.foodcouriers.ui.components.HomeCarousel
import com.foodcouriers.ui.components.HomeMenuList
import com.foodcouriers.ui.components.HomeFiltersCard
import com.foodcouriers.ui.components.HomeSearchBar

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    var selectedCategoryIndex = remember { mutableStateOf(0) }

    Scaffold(
        topBar = { HomeTopBar() },
        bottomBar = {
            BottomNavigationBar(navController = navController)

        }
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
                    .padding(padding)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    HomeSearchBar()
                    Spacer(modifier = Modifier.height(4.dp))
                    HomeCarousel(
                        listOf(
                            R.drawable.pc_carusel,
                            R.drawable.pc_carusel,
                            R.drawable.pc_carusel,
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    HomeFilters(
                        categories = AppDataMocap.categories,
                        selectedCategoryIndex = selectedCategoryIndex.value,
                        onCategorySelected = { selectedCategoryIndex.value = it }
                    )
                    HomeFiltersCard(AppDataMocap.products)
                    Spacer(modifier = Modifier.height(4.dp))
                    HomeMenuList(AppDataMocap.MealMenuCards)
                }
            }
        }
    }
}