package com.example.carrotmarket.ui.user

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.dataclass.User
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.schedulers.Schedulers

class UserViewModel(private val repository: Repository) : ViewModel() {
    val user: MutableLiveData<User> = MutableLiveData()
    val id: Int = -1

    init{
        repository.getUserInfo(id)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(
                {//user.value = it
                     },
                { Log.d("error",it.toString())}
            )
    }

    //fun getUserInfo(id: Long) = repository.getUserInfo(id)
}