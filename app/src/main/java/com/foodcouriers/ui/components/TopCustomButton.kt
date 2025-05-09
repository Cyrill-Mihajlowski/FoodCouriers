package com.foodcouriers.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.foodcouriers.ui.theme.AppColors

@Composable
fun TopCustomButton(
    icon: Int,
    fontSize: Int = 45,
    click: () -> Unit
) {
    TextButton(
        onClick = click,
        modifier = Modifier
            .size(fontSize.dp)
            .background(
                color = AppColors.Pink_2,
                shape = RoundedCornerShape(8.dp),
            ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = "ic google",
                tint = Color.Unspecified,
//                modifier = Modifier.size(20.dp)
            )
        }
    }
}