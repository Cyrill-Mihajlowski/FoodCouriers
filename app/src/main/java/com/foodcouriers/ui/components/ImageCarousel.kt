package com.foodcouriers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.foodcouriers.R

@Composable
fun ImageCarousel(
    modifier: Modifier = Modifier,
    images: List<Int> = listOf(R.drawable.pc_carusel)
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp, bottom = 18.dp)
    ) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.pc_carusel),
                contentDescription = "Carousel Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(R.drawable.three_dots),
                contentDescription = "Three_dots",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }
    }
}
