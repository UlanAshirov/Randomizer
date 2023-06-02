package com.example.randomizer.di

import com.example.randomizer.remote.repository.UserRepository
import org.koin.dsl.module

val repoModule = module {
    factory { UserRepository(get()) }
}