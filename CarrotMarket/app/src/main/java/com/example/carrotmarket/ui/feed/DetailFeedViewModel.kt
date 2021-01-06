package com.example.carrotmarket.ui.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.api.ResponseComment
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailFeedViewModel(private val repository: Repository) : ViewModel() {
    val comments: MutableLiveData<List<ResponseComment>> = MutableLiveData()

//    init {
//        repository.getcomments()
//            .subscribeOn(Schedulers.io())
//            .observeOn(Schedulers.io())
//            .subscribe({
//                it -> comments.postValue(it)
//            },{ Log.d("commenterror", "detfeedviewmodel")})
//    }

    fun detailFeed(feed_id: Int): Single<Feed> {
        return repository.detailFeed(feed_id)
    }

    fun deleteFeed(feed_id: Int) {
        repository.deleteFeed(feed_id)
    }

    fun wrComment(feed_id: Int, comment: String) {
        repository.writeComment(feed_id, comment)
    }

    fun like(feed_id: Int) {
        repository.like(feed_id)
    }

    fun getComments(feed_id: Int) {
        repository.getComments(feed_id)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({ it ->
                comments.postValue(it)
            }, { Log.e("detailfeedvm", it.message.toString()) })
    }
}