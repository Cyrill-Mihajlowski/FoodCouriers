package com.foodcouriers.ui.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.foodcouriers.R
import com.foodcouriers.ui.components.AppLayout
import com.foodcouriers.ui.components.TopBar
import com.foodcouriers.ui.components.TopCustomButton
import com.foodcouriers.ui.theme.AppColors.gradientBrush_2
import com.foodcouriers.ui.theme.AppColors.gradientBrush_4
import com.foodcouriers.ui.theme.CustomStyles
import com.foodcouriers.ui.theme.Poppins
import com.foodcouriers.ui.theme.Roboto

@Composable
fun ChatScreen(navController: NavHostController) {
    val messages = listOf(
        ChatMessage("Hello! my name is Food Couriers\nbefore we start, what is your name?", true),
        ChatMessage("Emmanuel kamey", false),
        ChatMessage(
            "Hello! Emmanuel \uD83D\uDC4B.\nI can converse in your preferred\nlanguage. How may I help you\ntoday?  ",
            true
        ),
        ChatMessage("Is there Fried Rice\nand pepper chicken?", false),
        ChatMessage("Bot typing....", true, isTyping = true)
    )

    val topBarIcons = mapOf<Int, () -> Unit>(
        R.drawable.ic_red_arrow_left to { navController.popBackStack() },
        R.drawable.ic_notifiaction to { },
    )

    AppLayout(
        topBar = { TopBar(topBarIcons) },
        contentPadding = PaddingValues(horizontal = 24.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 4.dp, bottom = 32.dp),
                text = stringResource(R.string.chat_title),
                style = CustomStyles.Chat_title,
            )
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                item {
                    Icon(
                        painter = painterResource(R.drawable.ic_chat_avatar),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    messages.forEach { chatItem ->
                        ChatBubble(
                            message = chatItem,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
            InputField(navController = navController)
        }
    }
}

@Composable
fun ChatBubble(message: ChatMessage, modifier: Modifier = Modifier) {
    val bubbleShape = if (message.isBot) {
        RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 16.dp,
            bottomStart = 16.dp,
            bottomEnd = 16.dp
        )
    } else {
        RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 0.dp,
            bottomStart = 16.dp,
            bottomEnd = 16.dp
        )
    }

    Box(
        modifier = modifier,
        contentAlignment = if (message.isBot) Alignment.CenterStart else Alignment.CenterEnd
    ) {
        Column(
            modifier = Modifier
                .clip(bubbleShape)
                .background(
                    brush = if (message.isBot) gradientBrush_4 else gradientBrush_2,
                    shape = bubbleShape
                )
                .padding(16.dp),
            horizontalAlignment = if (message.isBot) Alignment.Start else Alignment.End
        ) {
            Text(
                text = message.text,
                style = if (message.isBot) TextStyle(
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color(0xFF000000),
                    lineHeight = 20.sp,
                ) else TextStyle(
                    fontFamily = Roboto,
                    fontWeight = if (message.isTyping) FontWeight.Bold else FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color(0xFFFEFEFF),
                    lineHeight = 20.sp,
                )
            )
            if (message.isTyping) {
                DotTypingIndicator()
            }
        }
    }
}

@Composable
fun DotTypingIndicator() {
    // Реализация анимации точек
}

@Composable
fun InputField(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TopCustomButton(
                icon = R.drawable.ic_load_files,
                fontSize = 56,
                click = { navController.popBackStack() }
            )

            val searchQuery = remember { mutableStateOf("") }

            BasicTextField(
                value = searchQuery.value,
                onValueChange = { searchQuery.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
                    .height(56.dp)
                    .background(
                        color = Color(0xFFF9FAFB),
                        shape = RoundedCornerShape(8.dp)
                    ),

                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (searchQuery.value.isEmpty()) {
                            Text(
                                text = stringResource(R.string.chat_search_bar_title),
                                style = TextStyle(
                                    fontFamily = Poppins,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color(0x80000000),
                                    lineHeight = 8.sp,
                                )
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            innerTextField()
                        }
                        Icon(
                            painter = painterResource(R.drawable.ic_two_red_arrow),
                            contentDescription = null,
                            modifier = Modifier
                                .clickable(onClick = { }),
                            tint = Color.Unspecified
                        )
                    }
                }
            )
        }
    }
}

data class ChatMessage(
    val text: String,
    val isBot: Boolean,
    val isTyping: Boolean = false
)