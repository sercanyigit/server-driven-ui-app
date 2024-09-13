package com.sercan.yigit.server.driven.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sercan.yigit.server.driven.domain.model.RemoteModel
import com.sercan.yigit.server.driven.domain.usecase.HomeScreenUseCase
import com.sercan.yigit.server.driven.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val homeScreenUseCase: HomeScreenUseCase
) : ViewModel() {

    private val _data = MutableStateFlow<Resource<RemoteModel>>(Resource.Loading())
    val data: StateFlow<Resource<RemoteModel>> get() = _data

    init {
        fetchUI()
    }

    private fun fetchUI() {
        viewModelScope.launch {
            homeScreenUseCase
                .getScreenData()
                .catch {
                    _data.value = Resource.Error(message = "")
                }
                .collect {
                    _data.value = it
                }
        }
    }
}
