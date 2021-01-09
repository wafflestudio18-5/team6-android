package com.example.carrotmarket.api

import android.graphics.drawable.Drawable

data class Feed(
    val article_id: Int,
    val title: String,
    val article_writer_id: Int,
    val userProfile: UserProfile,
    val contents: String,
    val like_count: Int? = 0,
    var username: String? = null
)

data class RequestFeedBody(
    val title: String,
    val contents: String,
    val category: Int? = 1
)

//data class Rfeed(
//    val user_id: Int,
//    val article_id: Int,
//    val title: String,
//    val content: String
//)

data class Comment(
    val contents: String
)

data class ResponseComment(
    val comment_writer_id: Int,
    val userProfile: UserProfile,
    val article_id: Int,
    val comment_id: Int,
    val contents: String,
    var username: String? = null
)


data class Product(
    val id: Int,
    val title: String,
    val seller: User,
    val price: Int,
    val description: String,
    val sold: Boolean
)

data class RequestLogin(
    val username: String,
    val password: String
)

data class RequestUser(
    val username: String,
    val password: String,
    val email: String? = null,
    val first_name: String,
    val last_name: String
)

data class User(
    val id: Int,
    val username: String,
    val town: String? = null,
    val email: String? = null,
    val userProfile: UserProfile,
    var token: String
)

data class GetUsername(
    val username: String
)

data class UserProfile(
    val id: Int,
    val user_type: String,
    val area: String? = null,
    val nickname: String? = null
)

data class Message(
    val message:String
)