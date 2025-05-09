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
import androidx.compose.ui.draw.shadow
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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val nav_items = listOf(
        NavigationItem(
            listOf(Screen.Home.route, Screen.Home.MealMenuExpanded.route),
            stringResource(R.string.nav_home),
            R.drawable.ic_nav_home
        ),
        NavigationItem(
            listOf(Screen.Profile.route),
            stringResource(R.string.nav_profile),
            R.drawable.ic_nav_proffile
        ),
        NavigationItem(
            listOf(Screen.Order.route),
            stringResource(R.string.nav_order),
            R.drawable.ic_nav_buy
        ),
        NavigationItem(
            listOf(Screen.Chat.route),
            stringResource(R.string.nav_chat),
            R.drawable.ic_nav_chat
        )
    )

    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(bottom = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(24.dp),
                    ambientColor = Color.Black.copy(alpha = 0.1f),
                    spotColor = Color.Black.copy(alpha = 0.1f)
                )
                .background(
                    color = AppColors.White,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            nav_items.forEach { item ->
//                val isSelected = currentRoute == item.route
                val isSelected = item.route.any { route ->
                    currentRoute?.startsWith(route) == true
                }
                Row(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(item.route.first()) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                        .background(
                            color = if (isSelected) AppColors.Pink_2 else AppColors.Transparent,
                            shape = RoundedCornerShape(12.dp),
                        )
                        .padding(horizontal = 18.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Box(
                        modifier = Modifier.background(
                            color = if (isSelected) AppColors.Pink_2 else AppColors.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                    ) {

                    }
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Unspecified,
                    )
                    if (isSelected) {
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