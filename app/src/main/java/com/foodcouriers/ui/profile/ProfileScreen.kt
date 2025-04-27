package com.foodcouriers.ui.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.foodcouriers.ui.components.BottomNavigationBar

@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        Text(
            text = "Proffie Screen",
            fontSize = 24.sp,
            modifier = Modifier.padding(32.dp, top = 64.dp)
        )
    }
}