package com.example.carrotmarket.ui.feed

import androidx.lifecycle.ViewModel
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.repository.Repository
import java.util.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import com.example.carrotmarket.CarrotMarketApplication.Companion.pref

class CreateFeedViewModel(private val repository: Repository) : ViewModel() {
    val token: String = pref.user.token
    fun postFeed(title: String, contents: String): Single<Feed> {
        return repository.postFeed("Token ${token}", title, contents)
    }
}