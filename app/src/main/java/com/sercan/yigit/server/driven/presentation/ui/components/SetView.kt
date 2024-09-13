@file:OptIn(ExperimentalPagerApi::class)

package com.sercan.yigit.server.driven.presentation.ui.components

import com.sercan.yigit.server.driven.domain.model.ActionType
import com.sercan.yigit.server.driven.domain.model.Data
import com.sercan.yigit.server.driven.domain.model.ViewType
import com.sercan.yigit.server.driven.presentation.ShowScaffold
import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import com.google.accompanist.pager.ExperimentalPagerApi


@Composable
fun SetView(
    data: ArrayList<Data>,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (ActionType, String) -> Unit
) {
    data.forEach { value ->
        checkUiType(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = { actionType, id ->
                onClickAction(actionType, id)
            }
        )
    }
}

@Composable
private fun checkUiType(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (ActionType, String) -> Unit
) {
    when (value.viewType) {
        ViewType.UNKNOWN -> Text("HATTAAA")
        ViewType.SCAFFOLD -> ShowScaffold(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = { actionType, id ->
                onClickAction(actionType, id)
            }
        )
        ViewType.SLIDER -> HorizontalSliderComponent(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = {}
        )

        else -> Unit
    }
}
