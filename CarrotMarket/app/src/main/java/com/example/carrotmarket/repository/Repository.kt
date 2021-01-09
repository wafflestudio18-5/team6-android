package com.example.carrotmarket.repository

import com.example.carrotmarket.api.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class Repository(private val service: Service) {
    fun getFeed(token: String): Observable<List<Feed?>> {
        return service.getFeed(token)
    }

    fun getUserInfo(token: String) = service.getUser(token)

    fun signUp(
        username: String,
        password: String,
        email: String,
        first_name: String,
        last_name: String
    ) = service.signUp(RequestUser(username, password, email, first_name, last_name))

    fun login(username: String, password: String) = service.login(RequestLogin(username, password))

    fun postFeed(token: String, title: String, contents: String): Single<Feed> {
        return service.postFeed(token, RequestFeedBody(title, contents))
    }

    fun detailFeed(token: String, feed_id: Int): Single<Feed> {
        return service.detailFeed(token, feed_id)
    }

    fun deleteFeed(token: String, feed_id: Int): Single<Message> {
        return service.deleteFeed(token, feed_id)
    }

    fun editFeed(token: String, feed_id: Int, title: String, contents: String): Single<Feed> {
        return service.editFeed(token, feed_id, RequestFeedBody(title, contents))
    }

    fun writeComment(token: String, feed_id: Int, comment: String): Single<ResponseComment> {
        return service.writeComment(token, feed_id, Comment(comment))
    }

    fun getComments(token: String, feed_id: Int): Single<List<ResponseComment>> {
        return service.getComments(token, feed_id)
    }

    fun like(token: String, feed_id: Int): Single<String> {
        return service.like(token, feed_id)
    }

    fun getUsername(token: String, user_id: Int): Single<GetUsername> {
        return service.getUsername(token, user_id)
    }
}