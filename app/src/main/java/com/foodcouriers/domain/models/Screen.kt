package com.foodcouriers.domain.models

sealed class Screen(val route: String) {
    object Start : Screen("start")
    object Onboard : Screen("onboard")
    object Home : Screen("home") {
        object MealMenuExpanded : Screen("home/meal_menu_expanded")
        object DetailMenu : Screen("home/detail_menu")

//        object DetailMenu : Screen("home/detail_menu/{productId}") {
//            fun createRoute(productId: String) = "home/detail_menu/$productId"
//        }
    }
    object Profile : Screen("profile")
    object Chat : Screen("chat")
    object Order : Screen("order")
    object FinishOrder : Screen("finish_order")
    object Location : Screen("location")
}