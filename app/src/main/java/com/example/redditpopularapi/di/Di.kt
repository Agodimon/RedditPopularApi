package com.example.redditpopularapi.di

import com.example.redditpopularapi.data.source.remote.ApiSource
import com.example.redditpopularapi.data.source.remote.ApiSourceImpl
import com.example.redditpopularapi.data.source.remote.api.RetrofitInstance
import com.example.redditpopularapi.data.source.repository.Repository
import com.example.redditpopularapi.data.source.repository.RepositoryImpl

import com.example.redditpopularapi.ui.screens.MainFragment
import com.example.redditpopularapi.ui.screens.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Di {
    fun sourceModules() = module {
        single<ApiSource> {
            ApiSourceImpl(RetrofitInstance.api)
        }
    }

    fun repositoryModule() = module {
        single<Repository> {
            RepositoryImpl(get(), RetrofitInstance.api)
        }
    }

    fun viewModules() = module {
        scope<MainFragment> {
            viewModel { MainViewModel(get()) }
        }
    }
}