package com.example.composeplayground.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composeplayground.R

val Typography = Typography(
    defaultFontFamily = FontFamily(
        Font(R.font.opensans_regular, FontWeight.Normal, FontStyle.Normal),
        Font(R.font.opensans_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.opensans_light, FontWeight.Light, FontStyle.Normal),
        Font(R.font.opensans_light_italic, FontWeight.Light, FontStyle.Italic),
        Font(R.font.opensans_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.opensans_bold_italic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.opensans_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
        Font(R.font.opensans_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.opensans_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
        Font(R.font.opensans_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
    )
)