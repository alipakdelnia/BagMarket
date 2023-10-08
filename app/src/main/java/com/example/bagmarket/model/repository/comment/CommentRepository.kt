package com.example.bagmarket.model.repository.comment

import com.example.bagmarket.model.data.Comment

interface CommentRepository {

    suspend fun getAllComments(productId: String):List<Comment>
    suspend fun addNewComment(productId: String , text:String,IsSuccess : (String) -> Unit)

}