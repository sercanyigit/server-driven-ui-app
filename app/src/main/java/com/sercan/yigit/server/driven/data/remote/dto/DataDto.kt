package com.sercan.yigit.server.driven.data.remote.dto

import com.sercan.yigit.server.driven.domain.model.RemoteModel

data class DataDto(
    val result: RemoteModel,
    val success: Boolean
)

fun DataDto.getDtoData():RemoteModel{
    return  RemoteModel(
        result.data
    )
}
