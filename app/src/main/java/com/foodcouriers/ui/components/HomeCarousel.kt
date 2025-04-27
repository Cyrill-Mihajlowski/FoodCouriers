package com.foodcouriers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
            .padding(bottom = Dimens.Large2Padding)
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
                modifier = Modifier.fillMaxWidth()
            )
        }

//        Spacer(modifier = Modifier.height(Dimens.LargePadding))

        PagerIndicator(
            currentPage = pagerState.currentPage,
            pageCount = imageList.size,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun PagerIndicator(
    currentPage: Int,
    pageCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(top = 0.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { page ->
            val isSelected = currentPage == page
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(if (isSelected) 9.dp else 9.dp)
                    .background(
                        color = if (isSelected) Color.Red else Color.Gray,
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
            )
        }
    }
}