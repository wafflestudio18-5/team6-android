package com.example.carrotmarket.ui.feed

import androidx.lifecycle.ViewModel
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.repository.Repository
import java.util.*
import io.reactivex.rxjava3.core.Observable

class EditFeedViewModel(private val repository: Repository) : ViewModel() {
    fun editFeed(feed_id: Int, title: String, content: String): Observable<Feed> {
        return repository.editFeed(feed_id, title, content)
    }
}