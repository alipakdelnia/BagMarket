package com.example.bagmarket.model.repository.product

import com.example.bagmarket.model.data.Ads
import com.example.bagmarket.model.data.Product

interface ProductRepository {

    suspend fun getAllProducts() : List<Product>
    suspend fun getAllAds(): List<Ads>

}