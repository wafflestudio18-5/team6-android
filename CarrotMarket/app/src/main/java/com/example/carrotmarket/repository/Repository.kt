package com.example.carrotmarket.repository

import com.example.carrotmarket.api.Service


class Repository(private val service: Service){
    fun getUserInfo(id: Int) = service.getUser(id)
    //fun getUserInfo(id:Int) = service.getfeed()
}