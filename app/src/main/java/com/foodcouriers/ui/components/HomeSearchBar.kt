package com.foodcouriers.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodcouriers.R
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Dimens

@Composable
fun HomeSearchBar() {
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
            .padding(horizontal = 32.dp)
            .height(36.dp)
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
                        text = stringResource(R.string.SearchBarTitle),
                        style = CustomStyles.searchField,
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

//    TextField(
//        value = searchQuery.value,
//        onValueChange = { newValue -> searchQuery.value = newValue },
//        placeholder = {
//            Text(
//                text = stringResource(R.string.SearchBarTitle),
//                style = CustomStyles.searchField,
//            )
//        },
//
//        leadingIcon = {
//            Icon(
//                painter = painterResource(R.drawable.ic_search),
//                contentDescription = "Search Icon",
//                tint = AppColors.Dark,
//                modifier = Modifier.padding(start = 8.dp)
//            )
//        },
//
//        modifier = Modifier
//            .fillMaxWidth()
//            .heightIn(max = 36.dp)
////            .wrapContentHeight(Alignment.Top)
//            .padding(horizontal = Dimens.ExtraLargePadding)
//        .background(
//                brush = gradientBrush,
//                shape = RoundedCornerShape(8.dp)
//            ),
//        shape = RoundedCornerShape(8.dp),
//        colors = TextFieldDefaults.colors(
//            unfocusedContainerColor = AppColors.Transparent,
//            unfocusedIndicatorColor = AppColors.Transparent,
//            focusedIndicatorColor = AppColors.Transparent,
//            focusedTextColor = AppColors.Dark
//        ),
//        textStyle = LocalTextStyle.current.copy(
//            fontSize = 12.sp,
//            lineHeight = 14.sp
//        ),
//        singleLine = true,
//    )
}