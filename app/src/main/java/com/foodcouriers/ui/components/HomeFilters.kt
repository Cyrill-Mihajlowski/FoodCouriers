package com.foodcouriers.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.foodcouriers.ui.theme.CustomStyles

@Composable
fun HomeFilters(
    categories: List<Pair<Int, String>>,
    selectedCategoryIndex: Int,
    onCategorySelected: (Int) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
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