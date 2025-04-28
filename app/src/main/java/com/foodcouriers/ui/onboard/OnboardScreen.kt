package com.foodcouriers.ui.onboard

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.foodcouriers.ui.components.BottomNavigationBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.foodcouriers.R
import com.foodcouriers.domain.models.ProductItems
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Dimens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardScreen(navController: NavController) {
    val slideNumber: Int = 2

    val onboardingState = remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { slideNumber }
    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()
    val tabs = listOf("Create Account", "Login")
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ) { innerPadding ->

//        Image(
//            painter = painterResource(R.drawable.pattern_2),
//            contentDescription = "Background",
//            contentScale = ContentScale.FillWidth,
//            modifier = Modifier
//                .fillMaxWidth()
////                .align(Alignment.TopCenter)
////                .height(400.dp)
//        )

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(R.drawable.pattern_2),
                contentDescription = "Background",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
//                .align(Alignment.TopCenter)
//                .height(400.dp)
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> OnboardingSlide(
                        title = stringResource(R.string.slide_title),
                        description = stringResource(R.string.slide_text),
                        onNext = { coroutineScope.launch { pagerState.animateScrollToPage(1) } },
                        onSkip = {
                            coroutineScope.launch { modalBottomSheetState.show() }
                        }
                    )

                    1 -> OnboardingSlide(
                        title = stringResource(R.string.slide_title_2),
                        description = stringResource(R.string.slide_text_2),
                        onNext = {
                            coroutineScope.launch { modalBottomSheetState.show() }
                        },
                        onSkip = {
                            coroutineScope.launch { modalBottomSheetState.show() }
                        }
                    )
                }
            }
            // Индикатор для пейджера
            PagerIndicator(
                currentPage = pagerState.currentPage,
                pageCount = slideNumber,
                modifier = Modifier.align(Alignment.BottomCenter) // Расположение индикатора
            )
        }

        if (modalBottomSheetState.isVisible) {
            ModalBottomSheet(
                onDismissRequest = { coroutineScope.launch { modalBottomSheetState.hide() } },
                sheetState = modalBottomSheetState,
                scrimColor = Color.Transparent // TODO: Убираем затемнение
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TabRow(selectedTabIndex = selectedTab) {
                        tabs.forEachIndexed { index, text ->
                            Tab(
                                selected = selectedTab == index,
                                onClick = { selectedTab = index },
                                text = { Text(text) }
                            )
                        }
                    }

                    when (selectedTab) {
                        0 -> CreateAccountContent {
                            coroutineScope.launch {
                                modalBottomSheetState.hide() // Скрытие шторки
                                navController.navigate(Screen.Home.route)
                            }
                        }

                        1 -> LoginContent {
                            coroutineScope.launch {
                                modalBottomSheetState.hide() // Скрытие шторки
                                navController.navigate(Screen.Home.route)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OnboardingSlide(
    title: String,
    description: String,
    onNext: () -> Unit,
    onSkip: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        Text(text = description, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = onSkip) { Text("Skip") }
            Button(onClick = onNext) { Text("Next") }
        }
    }
}

@Composable
fun CreateAccountContent(onFinish: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Create Account", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Full Name") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Email Address") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Password") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onFinish
        ) {
            Text("Sign Up")
        }
    }
}

@Composable
fun LoginContent(onFinish: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Email Address") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Password") })
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = {}) { Text("Forgot Password?") }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onFinish) { Text("Login") }
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
                        color = if (isSelected) Color.Red else AppColors.Gray_3,
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
            )
        }
    }
}