package com.example.bagmarket.model.dataBase

import androidx.room.Database
import com.example.bagmarket.model.data.Product
import com.example.bagmarket.util.DATA_BASE_VERSION

@Database(entities = [Product::class], version = DATA_BASE_VERSION, exportSchema = false)
abstract class AppDatabase {
    abstract fun productDao(): ProductDao
}