package com.example.bagmarket.model.data


import com.google.gson.annotations.SerializedName

data class CommentsResponse(
    val comments: List<Comment>,
    val success: Boolean
) {
    data class Comment(
        val commentId: String,
        val text: String,
        val userEmail: String
    )
}