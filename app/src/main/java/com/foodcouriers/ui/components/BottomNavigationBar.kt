package com.foodcouriers.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.foodcouriers.R
import com.foodcouriers.domain.models.NavigationItem
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        NavigationItem(Screen.Home.route, "Home", R.drawable.ic_nav_home),
        NavigationItem(Screen.Profile.route, "Profile", R.drawable.ic_nav_proffile),
        NavigationItem(Screen.Order.route, "Order", R.drawable.ic_nav_buy),
        NavigationItem(Screen.Chat.route, "Chat", R.drawable.ic_nav_chat)
    )

    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = AppColors.White,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                val isSelected = currentRoute == item.route
                Row(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                        .background(
                            color = if (isSelected) AppColors.Pink_2 else AppColors.Transparent,
                            shape = RoundedCornerShape(12.dp),
                        )
                        .padding(horizontal = 20.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Box(
                        modifier = Modifier.background(
                            color = if (currentRoute == item.route) AppColors.Pink_2 else AppColors.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                    ) {

                    }
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        tint = if (currentRoute == item.route) MaterialTheme.colorScheme.primary else Color.Unspecified,
                    )
                    if (currentRoute == item.route) {
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = item.label,
                            style = CustomStyles.menuItems,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
            }
        }
    }
}