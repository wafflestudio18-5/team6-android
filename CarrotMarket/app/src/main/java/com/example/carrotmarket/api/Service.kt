package com.example.carrotmarket.api

import java.util.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*
import java.io.ObjectOutputStream
import java.net.ContentHandler

interface Service {
    @GET("/feed/")
    fun getFeed(): Single<List<Feed>>

    @POST("/feed/")
    fun postFeed(
        @Body body: RequestFeedBody
    ): Single<Feed>

    @GET("/feed/{feed_id}/")
    fun detailFeed(
        @Path("feed_id") feed_id: Int
    ): Single<Feed>

    @DELETE("/feed/{feed_id}/")
    fun deleteFeed(
        @Path("feed_id") feed_id: Int
    )

    @PUT("/feed/{feed_id}/")
    fun editFeed(
        @Path("feed_id") feed_id: Int,
        @Body body: RequestFeedBody
    ): Single<Feed>

    @POST("/feed/{feed_id}/comment/")
    fun writeComment(
        @Path("feed_id") feed_id: Int,
        @Body body: Comment
    )

    @GET("/feed/{feed_id}/comment/")
    fun getComments(
        @Path("feed_id") feed_id: Int
    ): Single<List<ResponseComment>>

    @POST("/feed/{feed_id}/like/")
    fun like(
        @Path("feed_id") feed_id: Int
    )
}

