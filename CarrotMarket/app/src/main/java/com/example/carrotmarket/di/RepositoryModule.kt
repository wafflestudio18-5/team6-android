package com.example.carrotmarket.di

import com.example.carrotmarket.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        Repository(get())
    }
}