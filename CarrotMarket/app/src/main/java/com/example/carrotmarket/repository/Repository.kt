package com.example.carrotmarket.repository

import com.example.carrotmarket.api.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


class Repository(private val service: Service) {
    fun getFeed(): Single<List<Feed>> {
        return service.getFeed()
    }

    fun postFeed(title: String, contents: String): Single<Feed> {
        return service.postFeed(RequestFeedBody(title, contents))
    }

    fun detailFeed(feed_id: Int): Single<Feed> {
        return service.detailFeed(feed_id)
    }

    fun deleteFeed(feed_id: Int) {
        service.deleteFeed(feed_id)
    }

    fun editFeed(feed_id: Int, title: String, contents: String): Single<Feed> {
        return service.editFeed(feed_id, RequestFeedBody(title, contents))
    }

    fun writeComment(feed_id: Int, comment: String) {
        service.writeComment(feed_id, Comment(comment))
    }

    fun getComments(feed_id: Int): Single<List<ResponseComment>> {
        return service.getComments(feed_id)
    }

    fun like(feed_id: Int) {
        service.like(feed_id)
    }
}