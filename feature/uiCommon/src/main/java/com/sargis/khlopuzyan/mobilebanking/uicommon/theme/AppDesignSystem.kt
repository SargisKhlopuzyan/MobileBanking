package com.sargis.khlopuzyan.mobilebanking.uicommon.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

data class AppShape(
    val container: Shape,
    val button: Shape,
    val circle: Shape,
)

data class AppSize(
    val large: Dp,
    val medium: Dp,
    val normal: Dp,
    val small: Dp,
)

val LocalShape = staticCompositionLocalOf {
    AppShape(
        container = RectangleShape,
        button = RectangleShape,
        circle = CircleShape,
    )
}

val LocalSize = staticCompositionLocalOf {
    AppSize(
        large = Dp.Unspecified,
        medium = Dp.Unspecified,
        normal = Dp.Unspecified,
        small = Dp.Unspecified,
    )
}