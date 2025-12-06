package com.sargis.khlopuzyan.mobilebanking.uicommon.supportmultiScreenSizes

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalWindowInfo

data class WindowSize (
    val width: WindowType,
    val height: WindowType,
)

enum class WindowType {
    Compact, Medium, Expended
}

@Composable
fun rememberWindowSizes() : WindowSize {
    val configuration = LocalConfiguration.current
    val containerSize = LocalWindowInfo.current.containerSize

    println("containerSize: $containerSize")

    return WindowSize(
        width = when {
            configuration.screenWidthDp < 600 -> WindowType.Compact
            configuration.screenWidthDp < 800 -> WindowType.Medium
            else -> WindowType.Expended
        },
        height = when {
            configuration.screenHeightDp < 800 -> WindowType.Compact
            configuration.screenHeightDp < 600 -> WindowType.Medium
            else -> WindowType.Expended
        }
    )
}