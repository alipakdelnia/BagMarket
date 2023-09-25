package com.example.bagmarket.model.repository.product

import com.example.bagmarket.model.data.Ads
import com.example.bagmarket.model.data.Product
import com.example.bagmarket.model.dataBase.ProductDao
import com.example.bagmarket.model.net.ApiService

class ProductRepositoryImpl(
    private val apiService: ApiService,
    private val productDao : ProductDao
):ProductRepository {
    override suspend fun getAllProducts(): List<Product> {


    }

    override suspend fun getAllAds(): List<Ads> {


    }
}