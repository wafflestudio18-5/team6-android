package com.example.carrotmarket.ui.user

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.CarrotMarketApplication.Companion.pref
import com.example.carrotmarket.api.User
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.schedulers.Schedulers

class UserViewModel(private val repository: Repository) : ViewModel() {
    var user:User = pref.user

    fun getUserInfo() =
        repository.getUserInfo("token " + pref.user.token)
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())
        .subscribe(
            {pref.user = it
                user = it
                Log.d("tag", "get user3 " + user.toString())
            },
            { Log.d("error",it.toString())}
        )
}