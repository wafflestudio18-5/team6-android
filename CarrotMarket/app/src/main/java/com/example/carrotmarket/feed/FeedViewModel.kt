package com.example.carrotmarket.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.schedulers.Schedulers

class FeedViewModel(private val repository: Repository) : ViewModel() {
    val feeds: MutableLiveData<List<Feed>> = MutableLiveData()

    init {
        repository.getFeed()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(
                {it->feeds.postValue(it)
                },{ Log.d("feedvm","error")}
            )
    }
}