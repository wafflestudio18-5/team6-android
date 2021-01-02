package com.example.carrotmarket.dataclass

import android.graphics.drawable.Drawable

data class User(
    val id: Long,
    val userName: String,
    val town: String?,
    val email: String?,
    val phoneNumber: String?,
    val profileImage: Drawable?,
    val token: String?
)