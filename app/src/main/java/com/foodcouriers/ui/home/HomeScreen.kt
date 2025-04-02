package com.foodcouriers.ui.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Log.d("HomeScreen", "Start HomeScreen")
    Text(
        text = "Привет",
        modifier = Modifier.padding(16.dp)
    )
}