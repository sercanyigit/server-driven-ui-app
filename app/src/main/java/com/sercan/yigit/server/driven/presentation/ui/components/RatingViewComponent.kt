package com.sercan.yigit.server.driven.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sercan.yigit.server.driven.domain.model.Data

@Composable
fun RatingViewComponent(value: Data) {
    value.value.isNotEmpty().let {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .wrapContentSize()
                .background(
                    color = Color(0xFF018601)
                )
                .padding(3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value.value,
                style = MaterialTheme.typography.labelLarge.copy(
                    letterSpacing = 0.1.sp
                ),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "star",
                modifier = Modifier.size(12.dp),
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RatingViewComponent() {
    RatingViewComponent(
        value = Data(
            value = "4.5"
        )
    )
}
