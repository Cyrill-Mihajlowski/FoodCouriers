package com.foodcouriers.ui.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.chat.ChatScreen
import com.foodcouriers.ui.detail_menu.DetailMenuScreen
import com.foodcouriers.ui.home.HomeScreen
import com.foodcouriers.ui.location.LocationScreen
import com.foodcouriers.ui.meal_menu.MealMenuExpandedScreen
import com.foodcouriers.ui.onboard.OnboardScreen
import com.foodcouriers.ui.order.FinishOrder
import com.foodcouriers.ui.order.OrderScreen
import com.foodcouriers.ui.profile.ProfileScreen
import com.foodcouriers.ui.start.StartScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Start.route,
    ) {
        composable(Screen.Start.route) {
            StartScreen(
                timeDelay = 2000,
                onNavigateToOnboard = {
                    navController.navigate(Screen.Onboard.route) {
                        popUpTo(Screen.Start.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Onboard.route) {
            OnboardScreen(
                navController = navController,
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Home.DetailMenu.route) {
            DetailMenuScreen(navController = navController)
        }
        composable(Screen.Home.MealMenuExpanded.route) {
            MealMenuExpandedScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.Order.route) {
            OrderScreen(navController = navController)
        }
        composable(Screen.Chat.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.FinishOrder.route) {
            FinishOrder(navController = navController)
        }
        composable(Screen.Location.route) {
            LocationScreen(navController = navController)
        }
    }
}