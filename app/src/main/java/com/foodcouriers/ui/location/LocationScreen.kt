package com.foodcouriers.ui.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.foodcouriers.R
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.components.CustomButton
import com.foodcouriers.ui.components.TopCustomButton
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.AppColors.gradientBrush_2
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Dimens
import com.foodcouriers.ui.theme.Poppins
import com.foodcouriers.ui.theme.Roboto

@Composable
fun LocationScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEFEFF)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.bg_maps),
            contentDescription = "Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 32.dp, bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TopCustomButton(
                        icon = R.drawable.ic_red_arrow_left,
                        click = { navController.popBackStack() }
                    )
                    TopCustomButton(
                        icon = R.drawable.ic_notifiaction,
                        click = {}
                    )
                }

                val gradientBrush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFFFF0F0),
                        Color(0xFFFFDFDF)
                    )
                )

                val searchQuery = remember { mutableStateOf("") }

                BasicTextField(
                    value = searchQuery.value,
                    onValueChange = { searchQuery.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 8.dp)
                        .height(43.dp)
                        .background(
                            brush = gradientBrush,
                            shape = RoundedCornerShape(8.dp)
                        ),

                    decorationBox = { innerTextField ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.width(Dimens.ExtraLargePadding))
                            Icon(
                                painter = painterResource(R.drawable.ic_search),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .clickable(onClick = { }),
                                tint = AppColors.Dark
                            )
                            Spacer(modifier = Modifier.width(Dimens.Medium3Padding))
                            if (searchQuery.value.isEmpty()) {
                                Text(
                                    text = stringResource(R.string.location_input_title),
                                    style = TextStyle(
                                        fontFamily = Roboto,
                                        fontWeight = FontWeight.Black,
                                        fontSize = 12.sp,
                                        color = Color(0xFF000000),
                                    ),
                                )
                            }
                            Box(
                                modifier = Modifier.weight(1f),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                innerTextField()
                            }
                        }
                    }
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(216.dp)
                        .background(
                            brush = gradientBrush_2,
                            shape = CircleShape,
                            alpha = 0.1F
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .background(
                                brush = gradientBrush_2,
                                shape = CircleShape,
                                alpha = 0.3F
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(32.dp)
                                .clickable(onClick = { }),
                            painter = painterResource(R.drawable.ic_location_label_big),
                            contentDescription = "ic location",
                            tint = Color.Unspecified,
                        )
                    }
                }
            }
            OrderPayBox()
        }
    }
}

@Composable
fun OrderPayBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(8.dp)
            ),
    ) {
        Column(
            modifier = Modifier
//                .fillMaxSize()
                .heightIn(min = 181.dp)
                .padding(top = 24.dp, start = 10.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.location_card_title),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0x4D3B3B3B),
                    )
                )
            }
            Row() {
                Icon(
                    painter = painterResource(R.drawable.ic_location_label),
                    contentDescription = null,
                    modifier = Modifier
//                        .padding(start = 8.dp)
                        .clickable(onClick = { }),
                    tint = Color.Unspecified
                )
                Text(
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .clickable(onClick = { }),
                    text = stringResource(R.string.location_card_text),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = Color(0xFF09051C),
                    )
                )
            }
        }

        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                .background(
                    brush = gradientBrush_2,
                    shape = RoundedCornerShape(8.dp),
                ),
            text = stringResource(R.string.location_bottom_button),
            textStyle = TextStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color(0xFFF6FAFE),
            )
        )
    }
}