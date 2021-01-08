package com.example.carrotmarket.repository

import com.example.carrotmarket.api.Service
import com.example.carrotmarket.dataclass.RequestLogin
import com.example.carrotmarket.dataclass.RequestUser


class Repository(private val service: Service){

    fun getUserInfo(token: String) = service.getUser(token)

    fun signUp(username: String, password: String, email: String, first_name: String, last_name: String)
            = service.signUp(RequestUser(username, password, email, first_name, last_name))

    fun login(username: String, password: String) = service.login(RequestLogin(username, password))
}