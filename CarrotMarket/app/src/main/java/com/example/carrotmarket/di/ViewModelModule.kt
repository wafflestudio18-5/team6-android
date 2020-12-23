package com.example.carrotmarket.di

import com.example.carrotmarket.ui.FeedViewModel
import com.example.carrotmarket.ui.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        FeedViewModel(get())
    }
    viewModel {
        UserViewModel(get())
    }
}