package com.example.redditpopularapi.data.models


import com.google.gson.annotations.SerializedName

data class GalleryData(
    @SerializedName("items")
    val items: List<Item>
)