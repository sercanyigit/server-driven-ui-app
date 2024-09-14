@file:OptIn(ExperimentalPagerApi::class)

package com.sercan.yigit.server.driven.presentation.ui.components

import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.sercan.yigit.server.driven.domain.model.Data
import com.sercan.yigit.server.driven.domain.model.enums.ActionType
import com.sercan.yigit.server.driven.domain.model.enums.ViewType

@Composable
fun SetView(
    data: ArrayList<Data>,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (ActionType, String) -> Unit
) {
    data.forEach { value ->
        CheckUiType(
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
private fun CheckUiType(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (ActionType, String) -> Unit
) {
    value.viewType?.let {
        when (it) {
            ViewType.UNKNOWN -> Text("Tanımsız Type")
            ViewType.ROW -> RowComponent(
                value = value,
                applicationContext = applicationContext,
                lifecycleScope = lifecycleScope,
                onClickAction = { actionType, id ->
                    onClickAction(actionType, id)
                }
            )
            ViewType.COLUMN -> ColumnComponent(
                value = value,
                applicationContext = applicationContext,
                lifecycleScope = lifecycleScope,
                onClickAction = { actionType, id ->
                    onClickAction(actionType, id)
                }
            )
            ViewType.VERTICAL_LIST -> VerticalListComponent(
                value = value,
                applicationContext = applicationContext,
                lifecycleScope = lifecycleScope,
                onClickAction = { actionType, id ->
                    onClickAction(actionType, id)
                }
            )
            ViewType.HORIZONTAL_LIST -> HorizontalListComponent(
                value = value,
                applicationContext = applicationContext,
                lifecycleScope = lifecycleScope,
                onClickAction = { actionType, id ->
                    onClickAction(actionType, id)
                }
            )
            ViewType.CARD -> CardViewComponent(
                value = value,
                applicationContext = applicationContext,
                lifecycleScope = lifecycleScope,
                onClickAction = { actionType, id ->
                    onClickAction(actionType, id)
                }
            )
            ViewType.IMAGE -> ImageComponent(
                value = value
            ) { actionType, id ->
                onClickAction(actionType, id)
            }
            ViewType.SLIDER -> HorizontalSliderComponent(
                value = value,
                applicationContext = applicationContext,
                lifecycleScope = lifecycleScope,
                onClickAction = {}
            )
            ViewType.VERTICAL_SPACER -> VerticalSpacerComponent(value = value)
            ViewType.HORIZONTAL_SPACER -> HorizontalSpacerComponent(value = value)
            ViewType.SIMPLE_HEADER_TEXT -> HeaderTextComponent(value = value)
            ViewType.TEXT -> TextComponent(value = value)
            ViewType.RATING -> RatingViewComponent(value = value)
            else -> Unit
        }
    } ?: run {
        Text("Tanımsız Type")
    }

}
