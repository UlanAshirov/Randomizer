package com.example.randomizer

import android.app.Application
import com.example.randomizer.di.networkModule
import com.example.randomizer.di.repoModule
import com.example.randomizer.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(networkModule, repoModule, viewModule)
        }
    }
}