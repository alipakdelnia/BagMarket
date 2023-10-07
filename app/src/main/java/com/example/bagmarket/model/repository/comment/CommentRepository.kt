package com.example.bagmarket.model.repository.comment

import com.example.bagmarket.model.data.CommentsResponse

interface CommentRepository {

    suspend fun getAllComments(product: String):List<CommentsResponse.Comment>

}