package com.example.carrotmarket.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.CarrotMarketApplication.Companion.pref
import com.example.carrotmarket.dataclass.User
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginViewModel(private val repository: Repository) : ViewModel() {
    var username: String = ""
    var password: String = ""
    var success: MutableLiveData<Boolean> = MutableLiveData(false)

    fun login(){
        if(username != "" && password != "")
            repository.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(
                    {pref.user = it
                        success.postValue(true)
                        Log.d("tag", "login success " + it.toString())
                    },
                    { Log.d("error",it.toString())}
                )
        else{
            Log.d("tag", "아이디와 비밀번호 필요")
        }
    }
}