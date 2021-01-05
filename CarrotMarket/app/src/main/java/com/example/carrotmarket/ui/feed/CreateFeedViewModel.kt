package com.example.carrotmarket.ui.feed

import androidx.lifecycle.ViewModel
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.api.Rfeed
import com.example.carrotmarket.repository.Repository
import java.util.*
import io.reactivex.rxjava3.core.Observable

class CreateFeedViewModel(private val repository: Repository) : ViewModel() {
    fun postFeed(title: String, contents: String): Observable<Feed> {
        return repository.postFeed(title, contents)
    }
}