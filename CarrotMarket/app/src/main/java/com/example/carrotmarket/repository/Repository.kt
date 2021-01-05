package com.example.carrotmarket.repository

import com.example.carrotmarket.api.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


class Repository(private val service: Service) {
    fun getFeed(): Single<List<Feed>> {
        return service.getfeed()
    }

    fun postFeed(title: String, contents: String): Observable<Feed> {
        return service.postfeed(Pfeed(title, contents))
    }

    fun detFeed(feed_id: Int): Observable<Feed> {
        return service.detfeed(feed_id)
    }

    fun delFeed(feed_id: Int) {
        service.delfeed(feed_id)
    }

    fun editFeed(feed_id: Int, title: String, contents: String): Observable<Feed> {
        return service.editfeed(feed_id, Pfeed(title, contents))
    }

    fun wrcomment(feed_id: Int, comment: String) {
        service.wrcomment(feed_id, Comment(comment))
    }

    fun getcomments(feed_id: Int): Observable<List<Rcomment>> {
        return service.getcomments(feed_id)
    }

    fun like(feed_id: Int) {
        service.like(feed_id)
    }
}