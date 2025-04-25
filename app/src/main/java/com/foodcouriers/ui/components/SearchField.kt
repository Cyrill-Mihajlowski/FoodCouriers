package com.foodcouriers.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.foodcouriers.R
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles

@Composable
fun SearchField() {
    TextField(
        value = "",
        onValueChange = { /* TODO: Обработать ввод текста */ },
        placeholder = {
            Text(
                text = "Search",
                style = CustomStyles.searchField
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search Icon",
                tint = AppColors.Dark
            )
        },

        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = AppColors.Pink_2,
            unfocusedIndicatorColor = AppColors.Transparent,
            focusedIndicatorColor = AppColors.Transparent
        ),
//        colors = TextFieldDefaults.colors(
//            focusedTextColor = MaterialTheme.colorScheme.primary,
//        )
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            backgroundColor = MaterialTheme.colorScheme.surface,
//            focusedBorderColor = MaterialTheme.colorScheme.primary,
//            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
//            textColor = MaterialTheme.colorScheme.onSurface,
//            placeholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
//        ), // TODO: FIX
        singleLine = true // Делаем поле однострочным
    )
}