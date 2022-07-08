package com.example.redditpopularapi.data.models.childrenModels


import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("data")
    val childrenData: ChildrenData,
    @SerializedName("kind")
    val kind: String
)