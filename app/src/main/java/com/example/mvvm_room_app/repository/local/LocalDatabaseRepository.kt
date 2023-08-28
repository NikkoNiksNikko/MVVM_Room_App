package com.example.mvvm_room_app.repository.local

import com.example.mvvm_room_app.models.`object`.Product
import com.example.mvvm_room_app.repository.local.dao.ProductDao
import kotlinx.coroutines.flow.Flow

class LocalDatabaseRepository(val database: ProductDao) : LocalRepository {
    override suspend fun insertProduct(product: Product){
        database.insertProduct(product)
    }

    override fun getAllProducts(): Flow<List<Product>> {
        return database.getAllProducts()
    }

    override fun searchProductsByName(name: String): Flow<List<Product>> {
        return database.searchProductsByName(name)
    }
}