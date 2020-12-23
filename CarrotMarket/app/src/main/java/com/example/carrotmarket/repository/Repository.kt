package com.example.carrotmarket.repository

import com.example.carrotmarket.api.Feed
import com.example.carrotmarket.api.Service
import io.reactivex.rxjava3.core.Observable


class Repository(private val service: Service){
    fun getFeed():Observable<List<Feed>>{
        return service.getfeed()
    }
}