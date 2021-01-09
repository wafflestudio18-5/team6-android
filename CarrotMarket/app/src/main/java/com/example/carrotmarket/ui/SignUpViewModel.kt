package com.example.carrotmarket.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.CarrotMarketApplication.Companion.pref
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.schedulers.Schedulers

class SignUpViewModel(private val repository: Repository) : ViewModel() {
    var username: String = ""
    var password: String = ""
    var email: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var success: MutableLiveData<Boolean> = MutableLiveData(false)

    fun signUp(){
        if(username != "" && password != "" && email != "" && firstName != "" && lastName != "")
            repository.signUp(username, password, email, firstName, lastName)
                .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(
                { Log.d("tag", "sign up success")
                    pref.user = it
                    success.postValue(true)
                },
                { Log.d("error",it.toString())}
            )
        else{
            Log.d("tag", "빈칸을 채워주세요")
        }
    }
}