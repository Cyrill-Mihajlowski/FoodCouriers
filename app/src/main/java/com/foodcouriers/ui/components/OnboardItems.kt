package com.foodcouriers.ui.components

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodcouriers.R
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.AppColors.gradientBrush_2
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Dimens

@Composable
fun OnboardingSlide(
    title: String,
    description: String,
    onNext: () -> Unit,
    onSkip: () -> Unit,
    currentPage: Int,
    pageCount: Int,
    imagePattern: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(imagePattern),
            contentDescription = "Background",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 64.dp, bottom = 32.dp)
        )
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 70.dp),
                text = title,
                style = CustomStyles.OnboardTitle,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(horizontal = 40.dp),
                text = description,
                style = CustomStyles.OnboardText,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            TextButton(
                onClick = onNext,
                modifier = Modifier
                    .background(
                        brush = gradientBrush_2,
                        shape = RoundedCornerShape(8.dp),
                    ),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(
                    start = 60.dp,
                    end = 60.dp,
                    top = 18.dp,
                    bottom = 18.dp
                )
            ) {
                Text(
                    text = stringResource(R.string.button_next),
                    style = CustomStyles.OnboardButton
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = onSkip,
                    modifier = Modifier.padding(0.dp),
                ) {
                    Text(
                        text = stringResource(R.string.button_skip),
                        style = CustomStyles.OnboardButtonSkip
                    )
                }
                PagerIndicatorCustom(
                    currentPage = currentPage,
                    pageCount = pageCount,
                )
                Icon(
                    painter = painterResource(R.drawable.red_arrow),
                    contentDescription = "red arrow",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(20.dp)
                        .size(14.dp)
                        .clickable(onClick = onSkip),
                )
            }
        }
    }
}

@Composable
fun CreateAccountContent(onFinish: () -> Unit) {
    val fieldsMap = mapOf(
        R.string.input_full_name to remember { mutableStateOf("") },
        R.string.input_email to remember { mutableStateOf("") },
        R.string.input_password to remember { mutableStateOf("") }
    )
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 36.dp)
        ) {
            fieldsMap.forEach { (titleRes, state) ->
                TextFieldCustom(
                    inputTitle = stringResource(id = titleRes),
                    state = state
                )
            }
        }
        ButtonCustom(
            onFinish = onFinish,
            buttonPink = stringResource(R.string.button_sign_up),
            buttonGrey = stringResource(R.string.button_sign_up_with_google)
        )
    }
}

@Composable
fun LoginContent(onFinish: () -> Unit) {
    val fieldsMap = mapOf(
        R.string.input_email to remember { mutableStateOf("") },
        R.string.input_password to remember { mutableStateOf("") },
    )
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            fieldsMap.forEach { (titleRes, state) ->
                TextFieldCustom(
                    inputTitle = stringResource(id = titleRes),
                    state = state
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.End
        ) {
            TextButton(onClick = {}) { Text(text = stringResource(R.string.textbutton_forget)) }
        }
        ButtonCustom(
            onFinish = onFinish,
            buttonPink = stringResource(R.string.button_login),
            buttonGrey = stringResource(R.string.button_login_with_google)
        )
    }
}

@Composable
fun ButtonCustom(
    onFinish: () -> Unit,
    buttonPink: String,
    buttonGrey: String
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 54.dp)
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        TextButton(
            onClick = onFinish,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = gradientBrush_2,
                    shape = RoundedCornerShape(8.dp),
                ),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = buttonPink,
                style = CustomStyles.OboardButtonRed
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 13.dp, horizontal = 40.dp)
                .height(1.dp)
                .background(Color(0xFFD2D4D8))
        )
        TextButton(
            onClick = onFinish,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = AppColors.Gray_3,
                    shape = RoundedCornerShape(8.dp),
                ),
            shape = RoundedCornerShape(8.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_google),
                    contentDescription = "ic google",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(Dimens.LargePadding))
                Text(
                    text = buttonGrey,
                    style = CustomStyles.OnboardSighuporLoginwith
                )
            }
        }
    }
}

@Composable
fun TextFieldCustom(
    inputTitle: String,
    state: MutableState<String>
) {
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        modifier = Modifier.padding(start = 34.dp),
        text = inputTitle,
        style = CustomStyles.OnboardInput
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = state.value,
        onValueChange = { newValue -> state.value = newValue },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .border(
                width = 1.dp,
                color = AppColors.Gray_3,
                shape = RoundedCornerShape(8.dp)
            )
            .heightIn(min = 40.dp, max = 48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = AppColors.Transparent,
            focusedContainerColor = AppColors.Transparent,
            unfocusedIndicatorColor = AppColors.Transparent,
            focusedIndicatorColor = AppColors.Transparent,
        ),
        textStyle = LocalTextStyle.current.copy(
            fontSize = 12.sp,
            lineHeight = 14.sp
        ),
        singleLine = true,
    )
}

@Composable
fun PagerIndicatorCustom(
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
                        color = if (isSelected) AppColors.Pink else AppColors.Gray_3,
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
            )
        }
    }
}