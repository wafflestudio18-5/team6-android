package com.example.carrotmarket.api

import com.example.carrotmarket.dataclass.RequestLogin
import com.example.carrotmarket.dataclass.RequestUser
import com.example.carrotmarket.dataclass.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface Service {
    @POST("user/")
    fun signUp(@Body requestUser: RequestUser): Single<User>

    @PUT("user/login/")
    fun login(@Body requestLogin: RequestLogin): Single<User>

    @GET("user/me/")
    fun getUser(@Header("Authorization") token: String): Single<User>
}