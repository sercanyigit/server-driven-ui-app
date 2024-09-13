package com.sercan.yigit.server.driven.domain.usecase

import com.sercan.yigit.server.driven.domain.model.RemoteModel
import com.sercan.yigit.server.driven.domain.repository.HomeScreenRepository
import com.sercan.yigit.server.driven.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeScreenUseCase @Inject constructor(
    private val homeScreenRepository: HomeScreenRepository
) {
    suspend fun getScreenData(): Flow<Resource<RemoteModel>> {
        return homeScreenRepository.fetchData()
    }
}