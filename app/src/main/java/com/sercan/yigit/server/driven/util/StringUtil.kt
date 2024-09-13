package com.sercan.yigit.server.driven.util


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sercan.yigit.server.driven.domain.model.Colors
import com.sercan.yigit.server.driven.domain.model.TextStyles
import com.sercan.yigit.server.driven.domain.model.TextType

fun String?.toDp(): Dp? {
    return this?.toFloat()?.dp
}

fun Colors?.toColorResource(): Color? {
    return when (this) {
        Colors.RED -> Color.Red
        Colors.WHITE -> Color.White
        Colors.BLUE -> Color.Blue
        else -> null
    }
}

fun TextType?.toFontWeight(): FontWeight? {
    return when (this) {
        TextType.BOLD -> FontWeight.Bold
        TextType.SEMI_BOLD -> FontWeight.SemiBold
        TextType.MEDIUM -> FontWeight.Medium
        TextType.NORMAL -> FontWeight.Normal
        TextType.LIGHT -> FontWeight.Light
        TextType.THIN -> FontWeight.ExtraLight
        else -> null
    }
}

@Composable
fun TextStyles?.toTextStyle(): TextStyle? {
    return when (this) {
        TextStyles.HEADLINE -> MaterialTheme.typography.headlineMedium
        TextStyles.TITLE -> MaterialTheme.typography.headlineMedium.copy(fontSize = 18.sp)
        TextStyles.SUBTITLE -> MaterialTheme.typography.labelMedium
        TextStyles.BODY -> MaterialTheme.typography.bodyMedium
        TextStyles.CAPTION -> MaterialTheme.typography.displayMedium
        null -> null
    }
}
