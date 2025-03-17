package com.foodcouriers.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.foodcouriers.ui.theme.FoodCouriersTheme
import com.foodcouriers.ui.screens.AppNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodCouriersTheme {
                AppNavigator()
            }
        }
    }
}