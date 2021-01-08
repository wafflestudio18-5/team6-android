package com.example.carrotmarket.ui.user.profile

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carrotmarket.CarrotMarketApplication.Companion.pref
import com.example.carrotmarket.api.User
import com.example.carrotmarket.repository.Repository
import io.reactivex.rxjava3.schedulers.Schedulers

class ProfileViewModel(private val repository: Repository) : ViewModel() {
    val user: User = pref.user
}