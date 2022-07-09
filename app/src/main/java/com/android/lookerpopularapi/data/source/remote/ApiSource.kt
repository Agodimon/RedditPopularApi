package com.android.lookerpopularapi.data.source.remote

import com.android.lookerpopularapi.data.models.popularItemModels.PopularItemRedditModel

interface ApiSource {
    suspend fun getData(): PopularItemRedditModel
    suspend fun getMoreData(after: String): PopularItemRedditModel
}