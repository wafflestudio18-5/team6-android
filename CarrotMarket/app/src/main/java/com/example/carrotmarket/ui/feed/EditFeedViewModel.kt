package com.example.carrotmarket.ui.feed

import androidx.lifecycle.ViewModel
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.repository.Repository
import java.util.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

import com.example.carrotmarket.CarrotMarketApplication.Companion.pref

class EditFeedViewModel(private val repository: Repository) : ViewModel() {
    val token: String = pref.user.token
    fun editFeed(feed_id: Int, title: String, content: String): Single<Feed> {
        return repository.editFeed("Token ${token}", feed_id, title, content)
    }
}