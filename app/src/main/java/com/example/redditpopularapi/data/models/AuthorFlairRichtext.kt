package com.example.redditpopularapi.data.models


import com.google.gson.annotations.SerializedName

data class AuthorFlairRichtext(
    @SerializedName("e")
    val e: String,
    @SerializedName("t")
    val t: String
)