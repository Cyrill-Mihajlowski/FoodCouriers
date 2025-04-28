package com.foodcouriers.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Dimens

@Composable
fun HomeFilters(
    categories: List<Pair<Int, String>>,
    selectedCategoryIndex: Int,
    onCategorySelected: (Int) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ExtraLargePadding, bottom = Dimens.SmallPadding)
    ) {
        itemsIndexed(categories) { index, category ->
            CategoryButton(
                icon = category.first,
                text = category.second,
                isSelected = index == selectedCategoryIndex,
                onClick = { onCategorySelected(index) }
            )
        }
    }
}

@Composable
fun CategoryButton(
    icon: Int,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Color(0xFFD61355) else Color.White
    val textColor = if (isSelected) Color.White else Color(0xFF0D0D0D)

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        modifier = Modifier
            .padding(end = Dimens.Medium2Padding)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = if (isSelected) 0.dp else 1.dp,
                color = AppColors.Pink_3,
                shape = RoundedCornerShape(8.dp)
            ),

        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(
            start = 14.dp,
            end = 16.dp,
            top = 0.dp,
            bottom = 0.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = text,
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(Dimens.LargePadding))
            Text(
                text = text,
                style = CustomStyles.filterItems,
                color = textColor
            )
        }
    }
}