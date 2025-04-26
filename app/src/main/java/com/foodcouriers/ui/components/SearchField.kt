package com.foodcouriers.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import com.foodcouriers.R
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles

@Composable
fun SearchField() {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFFF0F0),
            Color(0xFFFFDFDF)
        )
    )

    val searchQuery = remember { mutableStateOf("") }

    TextField(
        value = searchQuery.value,
        onValueChange = { newValue -> searchQuery.value = newValue },
        placeholder = {
            Text(
                text = "Search",
                style = CustomStyles.searchField,
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search Icon",
                tint = AppColors.Dark,
                modifier = Modifier.padding(start = 12.dp)
            )
        },

        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 46.dp)
            .wrapContentHeight(Alignment.CenterVertically)
            .padding(horizontal = 20.dp)
            .background(
                brush = gradientBrush,
                shape = RoundedCornerShape(8.dp)
            ),
        shape = RoundedCornerShape(8.dp),

        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = AppColors.Transparent,
            unfocusedIndicatorColor = AppColors.Transparent,
            focusedIndicatorColor = AppColors.Transparent,
            focusedTextColor = AppColors.Dark
        ),
        singleLine = true,
    )
}