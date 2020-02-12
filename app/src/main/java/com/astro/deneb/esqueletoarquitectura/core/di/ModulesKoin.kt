package com.astro.deneb.esqueletoarquitectura.core.di

import com.astro.deneb.esqueletoarquitectura.BuildConfig
import com.astro.deneb.esqueletoarquitectura.core.extensions.SharedPreferences
import com.astro.deneb.esqueletoarquitectura.core.platform.ContextHandler
import com.astro.deneb.esqueletoarquitectura.core.platform.NetworkHandler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module(override = true) {
    factory { ContextHandler(get()) }
    factory { NetworkHandler(get()) }
    single {
        Retrofit.Builder()
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
    }
}

val applicationModule = module(override = true) {
    single { SharedPreferences.defaultPrefs(get()) }
/*    scope(named<HomeFragment>()){
        *//*scoped { Navigator() }
        scoped { ArticleAdapter() }*//*
    }*/
}

val adapterModule = module {
    //factory { PodAdapter() }
}

val datasourceModule = module {
    //factory { PodService(get()) }
}

val repositoryModule = module {
    //factory<PodRepository> { PodRepository.PodRepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    //factory { GetPod(get()) }

}

val viewModelModule = module {
    //viewModel { GetPodViewModel(get()) }
}

private fun createClient(): OkHttpClient {
    val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    okHttpClientBuilder.readTimeout(20L, TimeUnit.SECONDS)
    okHttpClientBuilder.connectTimeout(20L, TimeUnit.SECONDS)
    okHttpClientBuilder.writeTimeout(20L, TimeUnit.SECONDS)
    if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
    }
    return okHttpClientBuilder.build()
}