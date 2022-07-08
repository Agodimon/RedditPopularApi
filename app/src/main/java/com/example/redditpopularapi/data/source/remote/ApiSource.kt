package com.example.redditpopularapi.data.source.remote

import com.example.redditpopularapi.data.models.popularItemModels.PopularItemRedditModel

interface ApiSource {
    suspend fun getData(): PopularItemRedditModel
    suspend fun getMoreData(after: String): PopularItemRedditModel
}