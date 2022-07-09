package com.android.lookerpopularapi.data.models.popularItemModels


import com.android.lookerpopularapi.data.models.childrenModels.Children
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("after")
    val after: String,
    @SerializedName("before")
    val before: Any,
    @SerializedName("children")
    val children: List<Children>,

    )