package com.example.bagmarket.model.data



data class SubmitOrder(
    val success: Boolean,
    val orderId: Int,
    val paymentLink: String
)