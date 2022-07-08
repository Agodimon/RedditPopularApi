package com.example.redditpopularapi.data.models


import com.google.gson.annotations.SerializedName

data class LinkFlairRichtext(
    @SerializedName("a")
    val a: String,
    @SerializedName("e")
    val e: String,
    @SerializedName("t")
    val t: String,
    @SerializedName("u")
    val u: String
)