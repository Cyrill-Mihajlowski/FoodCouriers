package com.foodcouriers.domain.models

data class NavigationItem(
    val route: List<String>,
    val label: String,
    val icon: Int
)