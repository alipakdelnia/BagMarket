package com.example.bagmarket.ui.features.product

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bagmarket.model.data.Comment
import com.example.bagmarket.model.repository.comment.CommentRepository
import com.example.bagmarket.model.repository.product.ProductRepository
import com.example.bagmarket.util.EMPTY_PRODUCT
import com.example.bagmarket.util.coroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProductViewModel(
    private val productRepository: ProductRepository,
    private val commentRepository: CommentRepository
) : ViewModel() {
    val thisProduct = mutableStateOf(EMPTY_PRODUCT)
    val comments = mutableStateOf(listOf<Comment>())

    fun loadData(productId: String, isInternetConnected: Boolean) {
        loadProductFromCache(productId)

        if (isInternetConnected) {
            loadAllComments(productId)
        }
    }

     fun loadProductFromCache(productId: String) {
        viewModelScope.launch(coroutineExceptionHandler) {
            thisProduct.value = productRepository.getProductById(productId)
        }
    }

     fun loadAllComments(productId: String) {
        viewModelScope.launch(coroutineExceptionHandler) {
            comments.value = commentRepository.getAllComments(productId)
        }
    }

     fun addNewComment (productId: String , text:String , IsSuccess:(String) -> Unit){
        viewModelScope.launch(coroutineExceptionHandler) {
            commentRepository.addNewComment(productId,text,IsSuccess)
            delay(100)
            comments.value = commentRepository.getAllComments(productId)
        }
    }
}