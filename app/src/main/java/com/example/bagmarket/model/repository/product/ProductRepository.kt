package com.example.bagmarket.model.repository.product

import com.example.bagmarket.model.data.Ads
import com.example.bagmarket.model.data.Product

interface ProductRepository {

    suspend fun getAllProducts(isInternetConnected : Boolean) : List<Product>
    suspend fun getAllAds(isInternetConnected : Boolean): List<Ads>

}