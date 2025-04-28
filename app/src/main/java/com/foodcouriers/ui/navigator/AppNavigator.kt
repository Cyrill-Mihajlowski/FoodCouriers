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

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun AppNavigator() {
//    Log.d("AppNavigator", "Start AppNavigator")
//
//    val navController = rememberNavController()
//
////    val currentBackStackEntry = navController.currentBackStackEntryAsState()
////    val currentRoute = currentBackStackEntry.value?.destination?.route
//
////    Scaffold(
////        bottomBar = {
////            if (currentRoute != Screen.Onboard.route) {
////                BottomNavigationBar(navController = navController)
////            }
////        }
////    ) {
//        NavHost(
//            navController = navController,
//            startDestination = Screen.Home.route,
//        ) {
//            composable(Screen.Onboard.route) {
////                OnboardScreen(
////                    onContinue = { navController.navigate(Screen.Home.route) }
////                )
//            }
//            composable(Screen.Home.route) {
//                HomeScreen(navController = navController)
//            }
//            composable(Screen.Profile.route) {
//                ProfileScreen(navController = navController)
//            }
//            composable(Screen.Chat.route) {
////                ChatScreen()
//            }
//            composable(Screen.Order.route) {
////                OrderScreen()
//            }
//        }
//    }
////}


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
            StartScreen(onNavigateToOnboard = { navController.navigate(Screen.Onboard.route) })
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