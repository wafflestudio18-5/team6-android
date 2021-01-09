package com.example.carrotmarket.ui.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.CarrotMarketApplication.Companion.pref
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class FeedViewModel(private val repository: Repository) : ViewModel() {
    val feeds: MutableLiveData<List<Feed?>> = MutableLiveData()
    val token: String = pref.user.token

    init {

        repository.getFeed("Token ${token}")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    for (index in it.indices) {
                        var uname: String = " "
                        Log.d("token", it[index].toString())
                        if (it[index]?.article_writer_id != null) repository.getUsername(
                            "Token ${token}",
                            it[index]!!.article_writer_id
                        )
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                { uname = it.username }, {}
                            )
                        it[index]?.username = uname
                    }
                    feeds.postValue(it)
                    Log.d("feed", it.toString())
                }, { Log.e("feedvm", it.message.toString()) }
            )
    }
}