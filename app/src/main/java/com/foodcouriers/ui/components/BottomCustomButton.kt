package com.foodcouriers.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.foodcouriers.R
import com.foodcouriers.ui.theme.AppColors.gradientBrush_2
import com.foodcouriers.ui.theme.CustomStyles

@Composable
fun BottomCustomButton() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp)
    ) {
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
//                .padding(horizontal = 24.dp)
                .background(
                    brush = gradientBrush_2,
                    shape = RoundedCornerShape(8.dp),
                ),
            onClick = { },
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(
                top = 16.dp,
                bottom = 16.dp
            )
        ) {
            Text(
                text = stringResource(R.string.profile_button_edit),
                style = CustomStyles.OnboardButton
            )
        }
    }
}