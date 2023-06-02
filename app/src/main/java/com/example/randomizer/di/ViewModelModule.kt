package com.example.randomizer.di

import com.example.randomizer.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

    val viewModule = module {
        viewModel { MainViewModel(get()) }
    }
