package com.example.carrotmarket.di

import com.example.carrotmarket.ui.feed.FeedViewModel
import com.example.carrotmarket.ui.UserViewModel
import com.example.carrotmarket.ui.feed.CreateFeedViewModel
import com.example.carrotmarket.ui.feed.DetailFeedViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        FeedViewModel(get())
    }
    viewModel {
        UserViewModel(get())
    }
    viewModel {
        CreateFeedViewModel(get())
    }
    viewModel {
        DetailFeedViewModel(get())
    }
}