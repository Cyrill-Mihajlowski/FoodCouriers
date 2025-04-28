package com.foodcouriers.domain.models

sealed class Screen(val route: String) {
    object Start : Screen("start")
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Chat : Screen("chat")
    object Order : Screen("order")
    object Onboard : Screen("onboard")
}