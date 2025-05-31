package com.foodcouriers.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    shape: Shape = RoundedCornerShape(8.dp),
    contentPadding: PaddingValues = PaddingValues(top = 16.dp, bottom = 16.dp),
    elevation: ButtonElevation? = null,
    text: String,
    textStyle: TextStyle
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        contentPadding = contentPadding,
        elevation = elevation,
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}