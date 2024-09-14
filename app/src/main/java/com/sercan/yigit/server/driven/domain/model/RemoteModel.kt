package com.sercan.yigit.server.driven.domain.model

import com.google.gson.annotations.SerializedName
import com.sercan.yigit.server.driven.domain.model.enums.ActionType
import com.sercan.yigit.server.driven.domain.model.enums.Colors
import com.sercan.yigit.server.driven.domain.model.enums.TextStyles
import com.sercan.yigit.server.driven.domain.model.enums.TextType
import com.sercan.yigit.server.driven.domain.model.enums.ViewType

data class RemoteModel(
    @SerializedName("data")
    val data: ArrayList<Data>? = null
)

data class Data(
    @SerializedName(value = "children")
    val children: ArrayList<Data>? = null,
    @SerializedName(value = "type")
    var viewType: ViewType = ViewType.UNKNOWN,
    @SerializedName("value")
    var value: String = "",
    @SerializedName("size")
    val size: Int? = null,
    @SerializedName("action")
    val action: ActionType = ActionType.UNKNOWN,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("padding")
    val padding: String? = null,
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("width")
    val width: String? = null,
    @SerializedName("radius")
    val cornerRadius: String? = null,
    @SerializedName("color")
    val color: Colors? = null,
    @SerializedName("textType")
    val textType: TextType? = null,
    @SerializedName("textStyle")
    val textStyle: TextStyles? = null,
    @SerializedName("cardItem")
    val cardItem: CardItem? = null,
    @SerializedName("alignment")
    val alignment: String? = null
)

data class CardItem(
    val name: String? = null,
    val rating: String? = null,
    val time: String? = null,
    val offer: String? = null,
    val imageURL: String? = null,
    val type: String? = null
)

