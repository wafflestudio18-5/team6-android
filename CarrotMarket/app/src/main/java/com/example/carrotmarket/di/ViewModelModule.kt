package com.example.carrotmarket.di

import com.example.carrotmarket.ui.LoginViewModel
import com.example.carrotmarket.ui.SignUpViewModel
import com.example.carrotmarket.ui.user.UserViewModel
import com.example.carrotmarket.ui.user.profile.ProfileViewModel
import com.example.carrotmarket.ui.feed.FeedViewModel
import com.example.carrotmarket.ui.feed.CreateFeedViewModel
import com.example.carrotmarket.ui.feed.DetailFeedViewModel
import com.example.carrotmarket.ui.feed.EditFeedViewModel
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
        LoginViewModel(get())
    }
    viewModel {
        SignUpViewModel(get())
    }
    viewModel {
        ProfileViewModel(get())
        CreateFeedViewModel(get())
    }
    viewModel {
        DetailFeedViewModel(get())
    }
    viewModel {
        EditFeedViewModel(get())
    }
}