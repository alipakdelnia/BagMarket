package com.example.bagmarket.ui.features.product

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bagmarket.model.data.CommentsResponse
import com.example.bagmarket.model.repository.comment.CommentRepository
import com.example.bagmarket.model.repository.product.ProductRepository
import com.example.bagmarket.util.EMPTY_PRODUCT
import com.example.bagmarket.util.coroutineExceptionHandler
import kotlinx.coroutines.launch

class ProductViewModel(
   private val productRepository: ProductRepository,
   private val commentRepository: CommentRepository
) : ViewModel() {
    val thisProduct = mutableStateOf(EMPTY_PRODUCT)
val comments = mutableStateOf(listOf<CommentsResponse.Comment>())

    fun loadData(productId: String,isInternetConnected : Boolean){
        loadProductFromCache(productId)

        if (isInternetConnected){
            loadAllComments(productId)
        }
    }

    private fun loadProductFromCache(productId:String){
        viewModelScope.launch(coroutineExceptionHandler) {
            thisProduct.value = productRepository.getProductById(productId)
        }
    }

    private fun loadAllComments(productId: String){
        viewModelScope.launch(coroutineExceptionHandler) {
comments.value = commentRepository.getAllComments(productId)
        }
    }
}