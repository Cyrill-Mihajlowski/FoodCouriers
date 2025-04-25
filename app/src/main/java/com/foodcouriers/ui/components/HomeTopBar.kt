package com.foodcouriers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.foodcouriers.R
import com.foodcouriers.ui.theme.AppColors

@Composable
fun HomeTopBar(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_top_menu),
            contentDescription = "Menu",
            modifier = Modifier
                .size(20.dp)
                .clickable { /* TODO: обработка нажатия */ }
        )
//        Spacer(modifier = Modifier.width(20.dp))
        Row() {
            Icon(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(18.dp)
                    .clickable { /* TODO: обработка нажатия */ },
                tint = AppColors.Pink
            )
            Text(
                text = "Freedom way, Lekki phase",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                color = AppColors.Dark
            )
        }
//        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.avatar_placeholder_2),
            contentDescription = "User Avatar",
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(AppColors.White)
        )
    }
}