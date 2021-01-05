package com.example.carrotmarket.api

data class Feed(
    val user_id: Int,
    val article_id: Int,
    val title: String,
    val content: String,
    val comment_count: Int,
    val like_count: Int
)

data class Pfeed(
    val title: String,
    val content: String
)

data class Rfeed(
    val user_id: Int,
    val article_id: Int,
    val title: String,
    val content: String
)

data class Comment(
    val contents_of_comment: String
)

data class Rcomment(
    val article_id: Int,
    val comment_id: Int,
    val user_id: Int,
    val contents_of_comment: String,
    val comment_writer_id: String
)