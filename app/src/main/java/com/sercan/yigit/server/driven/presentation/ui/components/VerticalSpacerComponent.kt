package com.sercan.yigit.server.driven.presentation.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sercan.yigit.server.driven.domain.model.Data

@Composable
fun VerticalSpacerComponent(
    value: Data,
) {
    Spacer(
        modifier = Modifier
            .height(value.height?.toFloat()?.dp ?: 0.dp)
    )
}
