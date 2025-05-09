package com.foodcouriers.ui.onboard

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.foodcouriers.R
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.components.CreateAccountContent
import com.foodcouriers.ui.components.LoginContent
import com.foodcouriers.ui.components.OnboardingSlide
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardScreen(navController: NavController) {
    val slideNumber: Int = 3

    val pagerState = rememberPagerState { slideNumber }
    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()
    val tabs = listOf(
        stringResource(R.string.checkbox_create_account),
        stringResource(R.string.checkbox_login)
    )
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(R.drawable.pattern_2),
                contentDescription = "Background",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                userScrollEnabled = false
            ) { page ->
                when (page) {
                    0 -> OnboardingSlide(
                        title = stringResource(R.string.slide_title),
                        description = stringResource(R.string.slide_text),
                        onNext = { coroutineScope.launch { pagerState.animateScrollToPage(1) } },
                        onSkip = {
                            coroutineScope.launch { modalBottomSheetState.show() }
                        },
                        currentPage = pagerState.currentPage,
                        pageCount = slideNumber,
                        imagePattern = R.drawable.pattern_3
                    )

                    1 -> OnboardingSlide(
                        title = stringResource(R.string.slide_title_2),
                        description = stringResource(R.string.slide_text_2),
                        onNext = {
                            coroutineScope.launch { modalBottomSheetState.show() }
                        },
                        onSkip = {
                            coroutineScope.launch { modalBottomSheetState.show() }
                        },
                        currentPage = pagerState.currentPage,
                        pageCount = slideNumber,
                        imagePattern = R.drawable.pattern_4
                    )
                }
            }
        }

        if (modalBottomSheetState.isVisible) {
            ModalBottomSheet(
                onDismissRequest = { coroutineScope.launch { modalBottomSheetState.hide() } },
                sheetState = modalBottomSheetState,
                scrimColor = Color.Transparent, // TODO: Убираем затемнение
                containerColor = Color.White,
                dragHandle = {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 24.dp)
                            .width(48.dp)
                            .height(4.dp)
                            .background(
                                brush = AppColors.dragHandlegradient,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TabRow(
                        modifier = Modifier.padding(bottom = 10.dp),
                        selectedTabIndex = selectedTab,
                        indicator = { tabPositions ->
                            Box(
                                modifier = Modifier
                                    .tabIndicatorOffset(tabPositions[selectedTab])
                                    .wrapContentSize(Alignment.BottomCenter) // Ограничиваем размер
                                    .width(77.dp) // Ширина индикатора
                                    .height(2.dp) // Высота индикатора
                                    .background(
                                        color = AppColors.Pink,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .align(Alignment.CenterHorizontally) // Явное выравнивание
//                                    .padding(horizontal = 16.dp) // Отступы от краев таба
                            )
                        },
                        divider = { /* Убираем разделитель */ }
                    ) {
                        tabs.forEachIndexed { index, text ->
                            Tab(
                                selected = selectedTab == index,
                                onClick = { selectedTab = index },
                                modifier = Modifier
                                    .height(40.dp), // Высота отдельного таба
                                text = {
                                    Text(
                                        text = text,
                                        style = CustomStyles.OnboardTab
                                    )
                                },
                                selectedContentColor = Color.Transparent, // Убираем дефолтную подсветку
                                unselectedContentColor = Color.Transparent
                            )
                        }
                    }
                    when (selectedTab) {
                        0 -> CreateAccountContent {
                            coroutineScope.launch {
                                modalBottomSheetState.hide()
                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.Onboard.route) { inclusive = true }
                                } // TODO:
//                                navController.navigate(Screen.Home.route)
                            }
                        }

                        1 -> LoginContent {
                            coroutineScope.launch {
                                modalBottomSheetState.hide()
                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.Onboard.route) { inclusive = true }
                                } // TODO:
//                                navController.navigate(Screen.Home.route)
                            }
                        }
                    }
                }
            }
        }
    }
}