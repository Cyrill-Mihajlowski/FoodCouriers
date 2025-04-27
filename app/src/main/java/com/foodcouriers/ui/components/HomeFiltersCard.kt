package com.foodcouriers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.foodcouriers.R
import com.foodcouriers.domain.models.ProductItems
import com.foodcouriers.ui.theme.AppColors
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Dimens

@Composable
fun HomeFiltersCard(
    products: List<ProductItems>
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ExtraLargePadding - 4.dp)
    ) {
        items(products) { product ->
            ProductCard(
                imageResId = product.imageResId,
                name = product.name,
                rating = product.rating,
                price = product.price,
                description = "100 gr chicken + tomato + cheese  Lettuce",
                onAddToCart = { /* TODO: добавить логику добавления в корзину */ }
            )
        }
    }
}

@Composable
fun ProductCard(
    imageResId: Int,
    rating: String,
    name: String,
    description: String,
    price: String,
    onAddToCart: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(top = 4.dp, end = Dimens.LargePadding, start = 4.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp),
    ) {
        Column(
            modifier = Modifier
                .background(AppColors.White)
                .padding(start = 6.dp, end = 6.dp, bottom = 10.dp)

        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = "Star",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                )
                Text(
                    text = rating,
                    modifier = Modifier.padding(start = 4.dp),
                    style = CustomStyles.cardRating
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = name,
                    style = CustomStyles.cardTitle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = CustomStyles.cardText,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Text(
                        text = price,
                        style = CustomStyles.cardPrice,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    IconButton(
                        onClick = onAddToCart,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_plus),
                            contentDescription = "Add to cart",
                        )
                    }
                }
            }
        }
    }
}