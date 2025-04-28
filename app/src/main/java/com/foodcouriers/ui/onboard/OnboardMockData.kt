package com.foodcouriers.ui.onboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.foodcouriers.R

object OnboardMockData {
    @Composable
    fun authData(): List<Pair<Int, String>> {
        return listOf(
            R.drawable.ic_burger to stringResource(R.string.category_burger),
            R.drawable.ic_pizza to stringResource(R.string.category_pizza),
            R.drawable.ic_sandwich to stringResource(R.string.category_sandwich)
        )
    }
}