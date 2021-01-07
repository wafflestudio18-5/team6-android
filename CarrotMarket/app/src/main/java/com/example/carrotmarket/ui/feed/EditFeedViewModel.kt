package com.example.carrotmarket.ui.feed

import androidx.lifecycle.ViewModel
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.repository.Repository
import java.util.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class EditFeedViewModel(private val repository: Repository) : ViewModel() {
    fun editFeed(feed_id: Int, title: String, content: String): Single<Feed> {
        return repository.editFeed(feed_id, title, content)
    }
}