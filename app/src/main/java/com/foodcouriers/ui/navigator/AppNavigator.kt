package com.foodcouriers.ui.navigator

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.components.BottomNavigationBar
import com.foodcouriers.ui.home.HomeScreen

@Composable
fun AppNavigator() {
    Log.d("AppNavigator", "Start AppNavigator")

    val navController = rememberNavController()

    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Onboard.route) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.Onboard.route) {
//                OnboardScreen(
//                    onContinue = { navController.navigate(Screen.Home.route) }
//                )
            }
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Profile.route) {
//                ProfileScreen()
            }
            composable(Screen.Chat.route) {
//                ChatScreen()
            }
            composable(Screen.Order.route) {
//                OrderScreen()
            }
        }
    }
}