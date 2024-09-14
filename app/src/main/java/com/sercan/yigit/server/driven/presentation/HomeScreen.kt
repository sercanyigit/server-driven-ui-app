package com.sercan.yigit.server.driven.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sercan.yigit.server.driven.domain.model.RemoteModel
import com.sercan.yigit.server.driven.domain.model.enums.ActionType
import com.sercan.yigit.server.driven.presentation.ui.components.SetView
import com.sercan.yigit.server.driven.presentation.ui.components.basecomponent.ShowErrorComponent
import com.sercan.yigit.server.driven.presentation.ui.components.basecomponent.ShowLoadingComponent
import com.sercan.yigit.server.driven.util.Resource


@Composable
fun HomeScreen(
homeViewModel: HomeScreenViewModel = hiltViewModel(),
navigateToOtherScreen: (ActionType, String) -> Unit
) {
    val data = homeViewModel.data

    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val uiDataFlow = remember(data, lifecycleOwner) {
        data.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }
    val uiData by uiDataFlow.collectAsState(Resource.Loading())

    when (uiData) {
        is Resource.Error -> ShowErrorComponent()
        is Resource.Loading -> ShowLoadingComponent()
        is Resource.Success -> SetView(
            data = (uiData as Resource.Success<RemoteModel>).data?.data ?: ArrayList(),
            applicationContext = context,
            lifecycleScope = lifecycleOwner.lifecycleScope,
            onClickAction = { actionType, id ->
                navigateToOtherScreen(actionType, id)
            }
        )
    }
}
