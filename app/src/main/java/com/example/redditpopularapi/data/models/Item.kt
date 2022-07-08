package com.example.redditpopularapi.data.models


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("caption")
    val caption: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("media_id")
    val mediaId: String
)