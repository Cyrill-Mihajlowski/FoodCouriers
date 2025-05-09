package com.foodcouriers.ui.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.foodcouriers.R
import com.foodcouriers.ui.theme.Dimens
import com.foodcouriers.ui.theme.Poppins
import com.foodcouriers.ui.theme.Roboto
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import com.foodcouriers.domain.models.Screen
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.AppColors.gradientBrush_2

@Composable
fun FinishOrder(navController: NavHostController) {
    var rating by remember { mutableIntStateOf(0) }

    val feedbackInput = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEFEFF)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.pattern_5),
            contentDescription = "Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
//                .padding(vertical = 64.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

//            Spacer(modifier = Modifier.height(Dimens.Medium2Padding))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 100.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_complete),
                    contentDescription = "logo",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .width(172.dp)
//                    .fillMaxWidth()
//                    .padding(horizontal = 64.dp)
                )
                Text(
                    modifier = Modifier.padding(bottom = 18.dp),
                    text = "Thank You!\nOrder Completed",
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color(0xFF000000),
                        lineHeight = 32.sp,
                        textAlign = TextAlign.Center
                    ),
                )
                Text(
                    text = "Please rate your last Driver",
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0x4D3B3B3B),
                        lineHeight = 20.sp,
                        textAlign = TextAlign.Center
                    ),
                )
                Row(
                    modifier = Modifier.padding(vertical = 30.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    repeat(5) { index ->
                        IconToggleButton(
                            checked = index < rating,
                            onCheckedChange = {
                                rating = if (index + 1 == rating) 0 else index + 1
                            }
                        ) {

                            Icon(
                                painter = if (index < rating) painterResource(R.drawable.ic_star_2) else painterResource(
                                    R.drawable.ic_star_1
                                ),
                                contentDescription = "Rating star",
                                tint = if (index < rating) Color(0xFFFEAD1D) else Color(0x4DFEAD1D),
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 32.dp)
            ) {
                BasicTextField(
                    value = feedbackInput.value,
                    onValueChange = { feedbackInput.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
//                        .padding(start = 12.dp)
                        .height(56.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = Color(0xFFF6F6F6),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .clickable(onClick = { }),
                                painter = painterResource(R.drawable.ic_edit_order),
                                contentDescription = null,

                                tint = Color.Unspecified
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            if (feedbackInput.value.isEmpty()) {
                                Text(
                                    text = stringResource(R.string.finish_order_input),
                                    style = TextStyle(
                                        fontFamily = Roboto,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 14.sp,
                                        color = Color(0x4D3B3B3B),
                                        lineHeight = 8.sp,
                                    )
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                innerTextField()
                            }
                        }
                    }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(
                        modifier = Modifier
//                            .fillMaxWidth()
//                            .align(Alignment.BottomCenter)
//                            .padding(horizontal = 24.dp)
//                            .padding(bottom = 12.dp)
                            .shadow(
                                elevation = 8.dp, // Интенсивность тени
                                shape = RoundedCornerShape(8.dp),
                                clip = true // Обрезает тень по форме
                            )
                            .background(
                                brush = gradientBrush_2,
                                shape = RoundedCornerShape(8.dp),
                            ),
                        onClick = { navController.navigate(Screen.Home.route) },
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(
                            vertical = 20.dp,
                            horizontal = 92.dp
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.finish_order_button_submit),
                            style = TextStyle(
                                fontFamily = Roboto,
                                fontWeight = FontWeight.Black,
                                fontSize = 14.sp,
                                color = Color(0xFFFEFEFF),
                            )
                        )
                    }
                    TextButton(
                        modifier = Modifier
//                            .fillMaxWidth()
//                            .align(Alignment.BottomCenter)
//                            .padding(horizontal = 24.dp)
//                            .padding(bottom = 12.dp)
                            .shadow(
                                elevation = 8.dp, // Интенсивность тени
                                shape = RoundedCornerShape(8.dp),
                                clip = true // Обрезает тень по форме
                            )
                            .background(
                                color = Color(0xFFFEFEFF),
                                shape = RoundedCornerShape(8.dp),
                            ),
                        onClick = { navController.navigate(Screen.Home.route) },
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(
                            vertical = 20.dp,
                            horizontal = 26.dp
                        ),
                    ) {
                        Text(
                            text = stringResource(R.string.finish_order_button_skip),
                            style = TextStyle(
                                fontFamily = Roboto,
                                fontWeight = FontWeight.Black,
                                fontSize = 14.sp,
                                brush = gradientBrush_2,
                            )
                        )
                    }
                }
            }
        }
    }
}