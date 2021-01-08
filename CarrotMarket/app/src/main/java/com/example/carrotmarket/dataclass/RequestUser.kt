package com.example.carrotmarket.dataclass

data class RequestUser(
    val username: String,
    val password: String,
    val email: String? = null,
    val first_name: String,
    val last_name: String
)