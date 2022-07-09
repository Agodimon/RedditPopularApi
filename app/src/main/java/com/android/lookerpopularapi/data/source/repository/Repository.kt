package com.android.lookerpopularapi.data.source.repository

import androidx.paging.PagingData
import com.android.lookerpopularapi.data.models.childrenModels.Children
import com.android.lookerpopularapi.data.models.popularItemModels.PopularItemRedditModel

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getData(): PopularItemRedditModel
    suspend fun getMoreData(): Flow<PagingData<Children>>
}