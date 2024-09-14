package com.sercan.yigit.server.driven.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sercan.yigit.server.driven.domain.model.Data
import com.sercan.yigit.server.driven.util.toColorResource
import com.sercan.yigit.server.driven.util.toDp
import com.sercan.yigit.server.driven.util.toFontWeight
import com.sercan.yigit.server.driven.util.toTextStyle

@Composable
fun TextComponent(
    value: Data
) {
    Text(
        text = value.value,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
        fontWeight = value.textType.toFontWeight(),
        color = value.color.toColorResource() ?: Color.Unspecified,
        style = value.textStyle.toTextStyle() ?: TextStyle.Default,
        modifier = Modifier
            .padding(
                start = value.padding.toDp() ?: 0.dp,
                end = value.padding.toDp() ?: 0.dp,
                top = value.padding.toDp() ?: 0.dp,
                bottom = value.padding.toDp() ?: 0.dp
            )
    )
}
