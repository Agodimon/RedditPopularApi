package com.example.redditpopularapi.data.models


import com.google.gson.annotations.SerializedName

data class SXX(
    @SerializedName("u")
    val u: String,
    @SerializedName("x")
    val x: Int,
    @SerializedName("y")
    val y: Int
)