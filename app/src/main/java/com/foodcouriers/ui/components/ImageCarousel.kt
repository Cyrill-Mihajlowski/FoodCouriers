package com.foodcouriers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.foodcouriers.R

@Composable
fun ImageCarousel() {
    val images = listOf(
        R.drawable.image_1,
        R.drawable.image_1,
        R.drawable.image_1
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(images) { imageRes ->
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Carousel Image",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(horizontal = 2.dp)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(images.size) { index ->
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .padding(4.dp)
                        .background(
                            color = if (index == 0) Color.Red else Color.Gray,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}
