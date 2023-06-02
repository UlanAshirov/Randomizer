package com.example.randomizer.di

import com.example.randomizer.BuildConfig.BASE_URL
import com.example.randomizer.remote.service.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideApiService() }
}

private fun provideApiService() =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)