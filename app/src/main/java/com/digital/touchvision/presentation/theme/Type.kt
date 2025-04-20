package com.digital.touchvision.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

val Typography = Typography(
    bodyLarge = TextStyle(
        color = Color.Black,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default,
        fontSize = 53.sp,
        fontWeight = FontWeight.Bold
    ),
    bodyMedium = TextStyle(
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default,
        fontSize = 29.sp,
        fontWeight = FontWeight.Bold
    ),
    bodySmall = TextStyle(
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default,
        fontSize = 27.sp,
        fontWeight = FontWeight.Bold
    ),
    titleLarge = TextStyle(
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default,
        fontSize = 114.sp,
        fontWeight = FontWeight.Bold
    ),
    titleSmall = TextStyle(
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
)