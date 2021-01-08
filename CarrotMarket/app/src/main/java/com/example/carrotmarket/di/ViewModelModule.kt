package com.example.carrotmarket.di

import com.example.carrotmarket.ui.FeedViewModel
import com.example.carrotmarket.ui.LoginViewModel
import com.example.carrotmarket.ui.SignUpViewModel
import com.example.carrotmarket.ui.user.UserViewModel
import com.example.carrotmarket.ui.user.profile.ProfileViewModel
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
    }
}