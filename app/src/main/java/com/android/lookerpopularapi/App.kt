package com.android.lookerpopularapi

import android.app.Application
import com.android.lookerpopularapi.di.Di
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    Di.sourceModules(),
                    Di.repositoryModule(),
                    Di.viewModules()
                )
            )
        }
    }
}