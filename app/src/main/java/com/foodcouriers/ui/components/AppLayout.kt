package com.foodcouriers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.foodcouriers.R

@Composable
fun AppLayout(
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    contentPadding: PaddingValues = PaddingValues(0.dp),
    background: @Composable () -> Unit = { DefaultBackground() },
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        containerColor = Color.Transparent
    ) { scaffoldPadding ->
        Box(Modifier.fillMaxSize()) {
            background()

            Box(
                modifier = Modifier
                    .padding(scaffoldPadding)
                    .padding(contentPadding)
                    .fillMaxSize()
            ) {
                content()
            }
        }
    }
}

@Composable
fun DefaultBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFDFF))
    ) {
        Image(
            painter = painterResource(R.drawable.background_1),
            contentDescription = "Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
    }
}