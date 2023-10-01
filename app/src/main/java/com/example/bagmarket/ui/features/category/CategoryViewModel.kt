package com.example.bagmarket.ui.features.category

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bagmarket.model.data.Product
import com.example.bagmarket.model.repository.product.ProductRepository
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val productRepository: ProductRepository
): ViewModel() {

    val dataProducts = mutableStateOf<List<Product>>(listOf())

    fun loadDataByCategory(category : String){
        viewModelScope.launch {
            val dataFromLocal = productRepository.getAllProductsByCategory(category)
            dataProducts.value = dataFromLocal
        }
    }
}