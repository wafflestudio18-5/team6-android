package com.example.carrotmarket.api


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

    @GET("/feed/")
    fun getFeed(@Header("Authorization") token: String): Observable<List<Feed?>>

    @POST("/feed/")
    fun postFeed(
        @Header("Authorization") token: String,
        @Body body: RequestFeedBody
    ): Single<Feed>

    @GET("/feed/{feed_id}/")
    fun detailFeed(
        @Header("Authorization") token: String,
        @Path("feed_id") feed_id: Int
    ): Single<Feed>

    @DELETE("/feed/{feed_id}/")
    fun deleteFeed(
        @Header("Authorization") token: String,
        @Path("feed_id") feed_id: Int
    ): Single<Message>

    @PUT("/feed/{feed_id}/")
    fun editFeed(
        @Header("Authorization") token: String,
        @Path("feed_id") feed_id: Int,
        @Body body: RequestFeedBody
    ): Single<Feed>


    @POST("/feed/{feed_id}/comment_write/")
    fun writeComment(
        @Header("Authorization") token: String,
        @Path("feed_id") feed_id: Int,
        @Body body: Comment
    ): Single<ResponseComment>

    @GET("/feed/{feed_id}/comment_list/")
    fun getComments(
        @Header("Authorization") token: String,
        @Path("feed_id") feed_id: Int
    ): Single<List<ResponseComment>>

    @POST("/feed/{feed_id}/like/")
    fun like(
        @Header("Authorization") token: String,
        @Path("feed_id") feed_id: Int
    ): Single<String>

    @GET("/user/{user_id}/")
    fun getUsername(
        @Header("Authorization") token: String,
        @Path("user_id") user_id: Int
    ): Single<GetUsername>
}
