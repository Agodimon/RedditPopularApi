package com.android.lookerpopularapi.di

import com.android.lookerpopularapi.data.source.remote.ApiSource
import com.android.lookerpopularapi.data.source.remote.ApiSourceImpl
import com.android.lookerpopularapi.data.source.remote.api.RetrofitInstance
import com.android.lookerpopularapi.data.source.repository.Repository
import com.android.lookerpopularapi.data.source.repository.RepositoryImpl

import com.android.lookerpopularapi.ui.screens.main.MainFragment
import com.android.lookerpopularapi.ui.screens.main.MainViewModel
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