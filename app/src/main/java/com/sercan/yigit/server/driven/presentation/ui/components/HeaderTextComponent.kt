package com.sercan.yigit.server.driven.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sercan.yigit.server.driven.domain.model.Data

@Composable
fun HeaderTextComponent(
    value: Data
) {
    Text(
        modifier = Modifier.padding(16.dp),
        text = value.value,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )
}
