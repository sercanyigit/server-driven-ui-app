package com.sercan.yigit.server.driven.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sercan.yigit.server.driven.domain.model.Data
import com.sercan.yigit.server.driven.domain.model.enums.ActionType
import com.sercan.yigit.server.driven.ui.R
import com.sercan.yigit.server.driven.util.toDp

@Composable
fun ImageComponent(
    value: Data,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(value.value)
            .crossfade(true)
            .placeholder(R.drawable.ic_placeholder_slider)
            .build(),
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(
                start = value.padding.toDp() ?: 0.dp,
                end = value.padding.toDp() ?: 0.dp,
                top = value.padding.toDp() ?: 0.dp,
                bottom = value.padding.toDp() ?: 0.dp
            )
            .size(
                width = value.width.toDp() ?: 0.dp,
                height = value.height.toDp() ?: 0.dp
            )
            .clip(
                shape = RoundedCornerShape(value.cornerRadius.toDp() ?: 0.dp)
            )
            .clickable {
                onClickAction(
                    value.action,
                    value.id ?: ""
                )
            }
    )
}
