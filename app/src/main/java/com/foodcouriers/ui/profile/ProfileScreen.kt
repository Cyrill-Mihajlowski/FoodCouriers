package com.foodcouriers.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.foodcouriers.R
import com.foodcouriers.ui.components.AppLayout
import com.foodcouriers.ui.components.CustomButton
import com.foodcouriers.ui.components.TopBar
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.AppColors.gradientBrush_2
import com.foodcouriers.ui.theme.CustomStyles

@Composable
fun ProfileScreen(navController: NavHostController) {
    val array_1 = mapOf(
        stringResource(R.string.profile_your_name) to "Joyce Johnson",
        stringResource(R.string.profile_occupation) to "Manager",
        stringResource(R.string.profile_empoyer) to "Food Couriers",
        stringResource(R.string.profile_country) to "Nigeria",
    )
    val array_2 = mapOf(
        stringResource(R.string.profile_phone_number) to "+234 813 0400 445",
        stringResource(R.string.profile_email) to "ekamcy@mail.com",
    )
    val topBarIcons = mapOf<Int, () -> Unit>(
        R.drawable.ic_red_arrow_left to { navController.popBackStack() },
        R.drawable.ic_notifiaction to { },
    )

    AppLayout(
        topBar = { TopBar(topBarIcons) },
        contentPadding = PaddingValues(horizontal = 24.dp),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 22.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = stringResource(R.string.profile_title_profile),
                        style = CustomStyles.Profile_title
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = AppColors.Pink_2,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_avatar),
                            contentDescription = "Heart",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(80.dp)
                                .clickable(onClick = {})
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_tabler_edit),
                            contentDescription = "Add",
                            modifier = Modifier
                                .size(28.dp)
                                .align(Alignment.BottomEnd)
                                .offset(x = (-2).dp, y = (-2).dp)
                                .clickable(onClick = {}),
                            tint = Color.Unspecified
                        )
                    }
                }
                ProfileItems(
                    title = stringResource(R.string.profile_personal_info),
                    array = array_1
                )
                ProfileItems(
                    title = stringResource(R.string.profile_contact_info),
                    array = array_2
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp),
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = gradientBrush_2,
                        shape = RoundedCornerShape(8.dp),
                    ),
                text = stringResource(R.string.profile_button_edit),
                textStyle = CustomStyles.OnboardButton,
            )
        }
    }
}

@Composable
fun ProfileItems(
    title: String,
    array: Map<String, String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp, bottom = 24.dp)
            .background(color = Color(0xFFFDFDFF))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                text = title,
                style = CustomStyles.Profile_title_2
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = AppColors.Gray_3,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp),
        ) {
            array.forEach { (textTitle, textValue) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = textTitle,
                        style = CustomStyles.Profile_title_3
                    )
                    Text(
                        text = textValue,
                        style = CustomStyles.Profile_title_item
                    )
                }
            }
        }
    }
}