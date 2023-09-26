package com.example.bagmarket.model.repository.product

import com.example.bagmarket.model.data.Ads
import com.example.bagmarket.model.data.Product
import com.example.bagmarket.model.dataBase.ProductDao
import com.example.bagmarket.model.net.ApiService

class ProductRepositoryImpl(
    private val apiService: ApiService,
    private val productDao : ProductDao
):ProductRepository {
    override suspend fun getAllProducts(isInternetConnected : Boolean): List<Product> {

        if(isInternetConnected){
            //get data from server
val dataFromServer = apiService.getAllProducts()
            if (dataFromServer.success){
                productDao.insertOrUpdate(dataFromServer.products)
                return dataFromServer.products
            }
        }else{
            //get data from local
            return productDao.getAll()
        }
return listOf()
    }


    override suspend fun getAllAds(isInternetConnected : Boolean): List<Ads> {

        if (isInternetConnected){
            val dataFromServer = apiService.getAllAds()
            if (dataFromServer.success){
                return dataFromServer.ads
            }
        }
        return listOf()

    }
}