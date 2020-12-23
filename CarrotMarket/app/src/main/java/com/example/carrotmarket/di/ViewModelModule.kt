package com.example.carrotmarket.di

import com.example.carrotmarket.ViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ViewModel(get())
}
}