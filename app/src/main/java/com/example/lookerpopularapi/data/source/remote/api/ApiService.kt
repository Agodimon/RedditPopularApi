package com.example.lookerpopularapi.data.source.remote.api

import com.example.lookerpopularapi.data.models.popularItemModels.PopularItemRedditModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top.json")
    suspend fun getPosts(): PopularItemRedditModel

    @GET("top.json")
    suspend fun getMorePosts(@Query("after") after: String): PopularItemRedditModel
}