package com.foodcouriers.ui.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.home.HomeScreen
import com.foodcouriers.ui.onboard.OnboardScreen
import com.foodcouriers.ui.profile.ProfileScreen
import com.foodcouriers.ui.start.StartScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

//    val currentBackStackEntry = navController.currentBackStackEntryAsState()
//    val currentRoute = currentBackStackEntry.value?.destination?.route

    NavHost(
        navController = navController,
        startDestination = Screen.Start.route,
    ) {
        composable(Screen.Start.route) {
            StartScreen(
                timeDelay = 2000, // TODO: 1000 = 1 секунда.
                onNavigateToOnboard = { navController.navigate(Screen.Onboard.route) }
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
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.Chat.route) {
//                ChatScreen()
        }
        composable(Screen.Order.route) {
//                OrderScreen()
        }
    }
}