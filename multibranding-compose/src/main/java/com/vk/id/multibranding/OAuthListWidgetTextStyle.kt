@file:OptIn(InternalVKIDApi::class)

package com.vk.id.multibranding

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.vk.id.common.InternalVKIDApi
import com.vk.id.multibranding.common.style.OAuthListWidgetTextStyle

@Composable
internal fun OAuthListWidgetTextStyle.asColorResource() = when (this) {
    OAuthListWidgetTextStyle.DARK -> Color.Black
    OAuthListWidgetTextStyle.LIGHT -> Color.White
}
