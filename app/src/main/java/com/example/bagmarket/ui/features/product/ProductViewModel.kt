package com.example.bagmarket.ui.features.product

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bagmarket.model.repository.product.ProductRepository
import com.example.bagmarket.util.EMPTY_PRODUCT
import com.example.bagmarket.util.coroutineExceptionHandler
import kotlinx.coroutines.launch

class ProductViewModel(
   private val productRepository: ProductRepository
) : ViewModel() {
    val thisProduct = mutableStateOf(EMPTY_PRODUCT)

    fun loadData(productId: String){
        loadProductFromCache(productId)
    }

    fun loadProductFromCache(productId:String){
        viewModelScope.launch(coroutineExceptionHandler) {
            thisProduct.value = productRepository.getProductById(productId)
        }
    }
}