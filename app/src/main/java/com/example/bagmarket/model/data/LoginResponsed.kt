package com.example.bagmarket.model.data

data class LoginResponsed(
    val expiresAt: Int,
    val message : String,
    val success: Boolean,
    val token : String
)
