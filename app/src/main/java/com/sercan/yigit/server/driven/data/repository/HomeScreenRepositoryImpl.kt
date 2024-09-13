package com.sercan.yigit.server.driven.data.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.sercan.yigit.server.driven.domain.model.RemoteModel
import com.sercan.yigit.server.driven.domain.repository.HomeScreenRepository
import com.sercan.yigit.server.driven.util.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class HomeScreenRepositoryImpl @Inject constructor(
    private val gson: Gson,
    @ApplicationContext private val context: Context
): HomeScreenRepository {

    override suspend fun fetchData(): Flow<Resource<RemoteModel>> {
        return withContext(Dispatchers.IO) {
            flow {
                emit(Resource.Loading())
                try {
                    //val result = homeScreenRepositoryImpl.fetchData()
                    val result = parseLocalJson()
                    emit(
                        Resource.Success(
                            data = result
                        )
                    )
                } catch (e: Exception) {
                    Log.e("Error", e.toString())
                    emit(
                        Resource.Error(
                            message = ""
                        )
                    )
                }
            }
        }
    }

    private fun parseLocalJson(): RemoteModel {

        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("MockData.json")
                .bufferedReader()
                .use { it.readText() }
                .replace("\n", "")
        } catch (ioException: IOException) {
        }
        return gson.fromJson(jsonString, RemoteModel::class.java)
    }
}