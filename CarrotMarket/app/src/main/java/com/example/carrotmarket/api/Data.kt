package com.example.carrotmarket.api

import android.graphics.drawable.Drawable

data class Feed(
    val user_id: Int,
    val article_id: Int,
    val title: String,
    val content: String,
    val comment_count: Int,
    val like_count: Int
)

data class RequestFeedBody(
    val title: String,
    val content: String
)

//data class Rfeed(
//    val user_id: Int,
//    val article_id: Int,
//    val title: String,
//    val content: String
//)

data class Comment(
    val contents_of_comment: String
)

data class ResponseComment(
    val article_id: Int,
    val comment_id: Int,
    val user_id: Int,
    val contents_of_comment: String,
    val comment_writer_id: String
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
    val phoneNumber: String? = null,
    val profileImage: Drawable? = null,
    var token: String
)