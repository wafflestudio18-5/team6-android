package com.example.carrotmarket.ui.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.api.Rcomment
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailFeedViewModel(private val repository: Repository) : ViewModel() {
    val comments: MutableLiveData<List<Rcomment>> = MutableLiveData()

//    init {
//        repository.getcomments()
//            .subscribeOn(Schedulers.io())
//            .observeOn(Schedulers.io())
//            .subscribe({
//                it -> comments.postValue(it)
//            },{ Log.d("commenterror", "detfeedviewmodel")})
//    }

    fun detFeed(feed_id: Int): Observable<Feed> {
        return repository.detFeed(feed_id)
    }

    fun delFeed(feed_id: Int) {
        repository.delFeed(feed_id)
    }

    fun wrcomment(feed_id: Int, comment: String) {
        repository.wrcomment(feed_id, comment)
    }

    fun like(feed_id: Int) {
        repository.like(feed_id)
    }

    fun getcomments(feed_id: Int) {
        repository.getcomments(feed_id)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({ it ->
                comments.postValue(it)
            }, {})
    }
}