package com.chiquito.zeroboundlearn.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.chiquito.zeroboundlearn.R

object AppFont{
    val Outfit = FontFamily(
        Font(R.font.outfit_thin, FontWeight.W100),
        Font(R.font.outfit_extra_light, FontWeight.W200),
        Font(R.font.outfit_light, FontWeight.W300),
        Font(R.font.outfit_regular, FontWeight.W400),
        Font(R.font.outfit_medium, FontWeight.W500),
        Font(R.font.outfit_semi_bold, FontWeight.W600),
        Font(R.font.outfit_bold, FontWeight.W700),
        Font(R.font.outfit_extra_bold, FontWeight.W800),
        Font(R.font.outfit_black, FontWeight.W900),
    )
}

private val defaultTypography = Typography()
// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = AppFont.Outfit),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = AppFont.Outfit),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = AppFont.Outfit),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFont.Outfit),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = AppFont.Outfit),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = AppFont.Outfit),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = AppFont.Outfit),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = AppFont.Outfit),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = AppFont.Outfit),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = AppFont.Outfit),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = AppFont.Outfit),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = AppFont.Outfit),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = AppFont.Outfit),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = AppFont.Outfit),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = AppFont.Outfit)
)


