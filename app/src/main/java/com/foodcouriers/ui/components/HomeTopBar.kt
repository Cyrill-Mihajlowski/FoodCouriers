package com.foodcouriers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.foodcouriers.R
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles

@Composable
fun HomeTopBar(navController: NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
            .padding(top = 34.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_top_menu),
            contentDescription = "Menu",
            modifier = Modifier
                .size(16.dp)
                .clickable { /* TODO: обработка нажатия */ }
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { navController.navigate(Screen.Location.route) }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(12.dp),
                tint = AppColors.Pink
            )
            Text(
                text = stringResource(R.string.top_bar_location),
                style = CustomStyles.topAppBar,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Image(
            painter = painterResource(R.drawable.ic_avatar),
            contentDescription = "User Avatar",
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(AppColors.White)
                .clickable { navController.navigate(Screen.Profile.route) }
        )
    }
}