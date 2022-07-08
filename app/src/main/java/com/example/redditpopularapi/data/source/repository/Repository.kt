package com.example.redditpopularapi.data.source.repository

import androidx.paging.PagingData
import com.example.redditpopularapi.data.models.childrenModels.Children
import com.example.redditpopularapi.data.models.popularItemModels.PopularItemRedditModel

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getData(): PopularItemRedditModel
    suspend fun getMoreData(): Flow<PagingData<Children>>
}