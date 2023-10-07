package com.example.bagmarket.model.repository.comment

import com.example.bagmarket.model.data.CommentsResponse
import com.example.bagmarket.model.net.ApiService
import com.google.gson.JsonObject

class CommentRepositoryImpl(private val apiService: ApiService) : CommentRepository {

    override suspend fun getAllComments(productId: String): List<CommentsResponse.Comment> {

            val jsonObject = JsonObject().apply {
                addProperty("productId",productId)
            }
        val data = apiService.getAllComments((jsonObject))

        if (data.success){
            return data.comments
        }

        return listOf()

    }

}