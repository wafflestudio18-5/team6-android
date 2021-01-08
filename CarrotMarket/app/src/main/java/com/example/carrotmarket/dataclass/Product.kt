package com.example.carrotmarket.dataclass

data class Product(
    val id: Int,
    val title: String,
    val seller: User,
    val price: Int,
    val description: String,
    val sold: Boolean
)