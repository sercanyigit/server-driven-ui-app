package com.sercan.yigit.server.driven.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.lifecycle.LifecycleCoroutineScope
import com.sercan.yigit.server.driven.domain.model.Data
import com.sercan.yigit.server.driven.domain.model.enums.ActionType

@Composable
fun ColumnComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    Column(
        horizontalAlignment = if (value.alignment.isNullOrEmpty()) Alignment.Start else Alignment.CenterHorizontally
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

/*
fun getModifier(value: Data): Modifier {

    return if (value.width != null) {
        Modifier
            .width(value.width.toDp() ?: 0.dp)
    } else Modifier
}
*/
