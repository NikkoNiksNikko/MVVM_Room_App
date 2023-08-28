package com.example.mvvm_room_app.repository.local

import com.example.mvvm_room_app.models.`object`.Product
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun insertProduct(product: Product)
    fun getAllProducts() : Flow<List<Product>>
    fun searchProductsByName(name: String): Flow<List<Product>>
}