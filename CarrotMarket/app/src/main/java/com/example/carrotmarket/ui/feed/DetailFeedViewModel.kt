package com.example.carrotmarket.ui.feed


import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.api.*
import com.example.carrotmarket.api.ResponseComment
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import com.example.carrotmarket.CarrotMarketApplication.Companion.pref
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class DetailFeedViewModel(private val repository: Repository) : ViewModel() {
    val comments: MutableLiveData<List<ResponseComment>> = MutableLiveData()
    val token: String = pref.user.token

//    init {
//        repository.getcomments()
//            .subscribeOn(Schedulers.io())
//            .observeOn(Schedulers.io())
//            .subscribe({
//                it -> comments.postValue(it)
//            },{ Log.d("commenterror", "detfeedviewmodel")})
//    }

    fun detailFeed(feed_id: Int): Single<Feed> {
        return repository.detailFeed("Token ${token}", feed_id)
    }

    fun deleteFeed(feed_id: Int): Single<Message> {
        return repository.deleteFeed("Token ${token}", feed_id)
    }

    fun wrComment(feed_id: Int, comment: String):Single<ResponseComment> {
        return repository.writeComment("Token ${token}", feed_id, comment)
    }

    fun like(feed_id: Int):Single<String> {
        return repository.like("Token ${token}", feed_id)
    }

    fun getComments(feed_id: Int) {
        repository.getComments("Token ${token}", feed_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                for (index in it.indices) {
                    var uname: String = " "
                    if (it[index]?.comment_writer_id != null) repository.getUsername(
                        "Token ${token}",
                        it[index]!!.comment_writer_id
                    )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            { uname = it.username }, {}
                        )
                    it[index]?.username = uname
                }
                comments.postValue(it)
                Log.d("com", it.toString())
            }, { Log.e("detailfeedvm", it.message.toString()) })
    }

    fun getUsername(user_id: Int): Single<GetUsername> {
        return repository.getUsername("Token ${token}", user_id)
    }
}