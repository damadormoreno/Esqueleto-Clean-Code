package com.astro.deneb.esqueletoarquitectura

import android.app.Application
import com.astro.deneb.esqueletoarquitectura.core.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(
                networkModule,
                datasourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule,
                adapterModule,
                applicationModule
            ))
        }
    }

}