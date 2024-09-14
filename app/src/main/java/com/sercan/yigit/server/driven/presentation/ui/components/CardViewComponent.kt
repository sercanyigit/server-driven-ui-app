package com.sercan.yigit.server.driven.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import com.sercan.yigit.server.driven.domain.model.Data
import com.sercan.yigit.server.driven.domain.model.enums.ActionType
import com.sercan.yigit.server.driven.util.toDp

@Composable
fun CardViewComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                start = value.padding?.toDp() ?: 0.dp,
                end = value.padding?.toDp() ?: 0.dp
            )
            .wrapContentSize(),
        shape = RoundedCornerShape(
            size = value.cornerRadius.toDp() ?: 4.dp
        )
    ) {
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
