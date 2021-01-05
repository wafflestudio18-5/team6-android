package com.example.carrotmarket.api

import java.util.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*
import java.io.ObjectOutputStream
import java.net.ContentHandler

interface Service {
    @GET("/feed/")
    fun getfeed(): Single<List<Feed>>

    @POST("/feed/")
    fun postfeed(
        @Body body: Pfeed
    ): Observable<Feed>

    @GET("/feed/{feed_id}/")
    fun detfeed(
        @Path("feed_id") feed_id:Int
    ):Observable<Feed>

    @DELETE("/feed/{feed_id}/")
    fun delfeed(
        @Path("feed_id") feed_id:Int
    )

    @PUT("/feed/{feed_id}/")
    fun editfeed(
        @Path("feed_id") feed_id:Int,
        @Body body: Pfeed
    ):Observable<Feed>

    @POST("/feed/{feed_id}/comment/")
    fun wrcomment(
        @Path("feed_id") feed_id:Int,
        @Body body:Comment
    )

    @GET("/feed/{feed_id}/comment/")
    fun getcomments(
        @Path("feed_id") feed_id: Int
    ):Observable<List<Rcomment>>

    @POST("/feed/{feed_id}/like/")
    fun like(
        @Path("feed_id") feed_id: Int
    )
}

