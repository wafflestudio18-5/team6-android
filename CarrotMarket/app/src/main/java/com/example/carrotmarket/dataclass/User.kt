package com.example.carrotmarket.dataclass

import android.graphics.drawable.Drawable

data class User(
    val id: Int,
    val username: String,
    val town: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val profileImage: Drawable? = null,
    var token: String
)