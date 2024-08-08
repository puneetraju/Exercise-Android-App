package com.example.exercise.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.exercise.R



val Kalam = FontFamily(
    Font(R.font.kalam_regular)
)
val Montserrat = FontFamily(
    Font(R.font.montserrat_bold )
)
val Ojuju = FontFamily(
    Font(R.font.ojuju_bold, FontWeight.Bold)
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    displayLarge = TextStyle(
        fontFamily = Ojuju,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Kalam,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize =20.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    )

)