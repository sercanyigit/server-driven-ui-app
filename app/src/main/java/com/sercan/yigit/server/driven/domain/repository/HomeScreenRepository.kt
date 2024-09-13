package com.sercan.yigit.server.driven.domain.repository

import com.sercan.yigit.server.driven.domain.model.RemoteModel
import com.sercan.yigit.server.driven.util.Resource
import kotlinx.coroutines.flow.Flow

interface HomeScreenRepository {

    suspend fun fetchData(): Flow<Resource<RemoteModel>>
}