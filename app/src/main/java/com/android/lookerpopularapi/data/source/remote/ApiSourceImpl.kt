package com.android.lookerpopularapi.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android.lookerpopularapi.data.models.childrenModels.Children
import com.android.lookerpopularapi.data.models.popularItemModels.PopularItemRedditModel
import com.android.lookerpopularapi.data.source.remote.api.ApiService

class ApiSourceImpl(private val api: ApiService): ApiSource,PagingSource<String, Children>() {
    override suspend fun getData(): PopularItemRedditModel = api.getPosts()
    override suspend fun getMoreData(after: String): PopularItemRedditModel =
        api.getMorePosts(after)

    override fun getRefreshKey(state: PagingState<String, Children>): String? {
        return state.pages.first().nextKey
    }

    override suspend fun load(params: PagingSource.LoadParams<String>): PagingSource.LoadResult<String, Children> {
        val nextPage: String = params.key.toString()
        val data = api.getMorePosts(nextPage).data.children
        val key = api.getMorePosts(nextPage).data.after
        return try {
            PagingSource.LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = key
            )

        } catch (e: Exception) {
            PagingSource.LoadResult.Error(e)
        }
    }
}