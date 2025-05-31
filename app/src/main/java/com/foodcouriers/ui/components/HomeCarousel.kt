package com.foodcouriers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.foodcouriers.ui.theme.Dimens

@Composable
fun HomeCarousel(imageList: List<Int>) {

    val pagerState = rememberPagerState { imageList.size }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.Large2Padding)
            .padding(top = Dimens.Medium2Padding, bottom = Dimens.Large2Padding)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) { page ->
            Image(
                painter = painterResource(id = imageList[page]),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { })
            )
        }

        PagerIndicator(
            currentPage = pagerState.currentPage,
            pageCount = imageList.size,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            cyrcleColor = Color.Red
        )
    }
}