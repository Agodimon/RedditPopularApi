package com.android.lookerpopularapi.data.source.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android.lookerpopularapi.data.models.childrenModels.Children
import com.android.lookerpopularapi.data.models.popularItemModels.PopularItemRedditModel
import com.android.lookerpopularapi.data.source.remote.ApiSource
import com.android.lookerpopularapi.data.source.remote.ApiSourceImpl
import com.android.lookerpopularapi.data.source.remote.api.ApiService

import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val dataSource: ApiSource,
    private val api: ApiService
) : Repository {
    override suspend fun getData(): PopularItemRedditModel = dataSource.getData()
    override suspend fun getMoreData(): Flow<PagingData<Children>> = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { ApiSourceImpl(api) }
    ).flow
}