package com.example.carrotmarket.api

import com.example.carrotmarket.dataclass.User
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("api/user/{id}/")
    fun getUser(@Path("id") id: Int): Observable<User>

    //@GET("api/feed/")
    //fun getfeed(): Observable<List<Feed>>
}

data class Feed(
    val body: String
)