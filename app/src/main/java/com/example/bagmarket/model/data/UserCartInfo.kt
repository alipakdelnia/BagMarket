package com.example.bagmarket.model.data

data class UserCartInfo(
    val success: Boolean,
    val productList: List<Product>,
    val message:String,
    val totalPrice: Int
)