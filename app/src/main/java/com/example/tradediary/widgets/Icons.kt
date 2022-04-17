package com.example.tradediary.widgets



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DiaryIcons(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onClick: () -> Unit,
    tint: Color = Color(0xFFFF5722),
    elevation: Dp = 6.dp
){
    Card(
        modifier = Modifier
            .padding(end = 30.dp)
            .clickable { onClick.invoke() },
        shape = CircleShape,
        backgroundColor = Color(0xFF000000),
        elevation = 6.dp
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "Add Icon",
            tint = tint)
    }
}