package com.sercan.yigit.server.driven.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import com.sercan.yigit.server.driven.domain.model.Data
import com.sercan.yigit.server.driven.domain.model.enums.ActionType

@Composable
fun HorizontalListComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            SetView(
                data = value.children ?: ArrayList(),
                applicationContext = applicationContext,
                lifecycleScope = lifecycleScope,
                onClickAction = { actionType, id ->
                    onClickAction(actionType, id)
                }
            )
        }
    }
}
