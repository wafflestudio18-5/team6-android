package com.example.carrotmarket.api

import java.util.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*
import java.io.ObjectOutputStream
import java.net.ContentHandler
import com.example.carrotmarket.dataclass.RequestLogin
import com.example.carrotmarket.dataclass.RequestUser
import com.example.carrotmarket.dataclass.User

interface Service {
    @POST("user/")
    fun signUp(@Body requestUser: RequestUser): Single<User>

    @PUT("user/login/")
    fun login(@Body requestLogin: RequestLogin): Single<User>

    @GET("user/me/")
    fun getUser(@Header("Authorization") token: String): Single<User>
  
  
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
