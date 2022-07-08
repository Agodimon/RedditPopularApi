package com.example.lookerpopularapi.data.source.remote

import com.example.lookerpopularapi.data.models.popularItemModels.PopularItemRedditModel

interface ApiSource {
    suspend fun getData(): PopularItemRedditModel
    suspend fun getMoreData(after: String): PopularItemRedditModel
}