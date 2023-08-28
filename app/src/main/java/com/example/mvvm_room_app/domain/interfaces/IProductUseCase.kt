package com.example.mvvm_room_app.domain.interfaces

import com.example.mvvm_room_app.domain.RequestCallback
import com.example.mvvm_room_app.models.`object`.Product
import kotlinx.coroutines.flow.Flow

interface IProductUseCase {
    suspend fun insertNewProduct(data: Product, requestCallback: RequestCallback<Product>)
    suspend fun getAllProducts(requestCallback: RequestCallback<List<Product>>)
    suspend fun searchProductsByName(name: String, requestCallback: RequestCallback<List<Product>>)
}