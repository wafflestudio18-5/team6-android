package com.example.carrotmarket.api

import retrofit2.http.GET
import java.util.*
import io.reactivex.rxjava3.core.Observable

interface Service {

    @GET("api/feed/")
    fun getfeed(): Observable<List<Feed>>
}

data class Feed(
    val body: String
)
