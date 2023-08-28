package com.example.mvvm_room_app.domain.usecases

import com.example.mvvm_room_app.domain.RequestCallback
import com.example.mvvm_room_app.domain.interfaces.IProductUseCase
import com.example.mvvm_room_app.models.`object`.Product
import com.example.mvvm_room_app.repository.local.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

class ProductUseCase(private val productRepository: LocalRepository) : IProductUseCase {
    override suspend fun insertNewProduct(
        data: Product,
        requestCallback: RequestCallback<Product>
    ) {
        withContext(Dispatchers.IO){
            try {
                productRepository.insertProduct(data)
                requestCallback.onSuccess(data)
            }catch (throwable: Throwable){
                requestCallback.onFail(throwable)
            }
        }
    }

    override suspend fun getAllProducts(requestCallback: RequestCallback<List<Product>>) {
       withContext(Dispatchers.IO){
            try {
                requestCallback.onSuccess(productRepository.getAllProducts().first())
            }catch (throwable: Throwable){
                requestCallback.onFail(throwable)
            }
        }
    }

    override suspend fun searchProductsByName(name: String, requestCallback: RequestCallback<List<Product>>) {
        withContext(Dispatchers.IO){
            try {
                requestCallback.onSuccess(productRepository.searchProductsByName(name).first())
            }catch (throwable: Throwable){
                requestCallback.onFail(throwable)
            }
        }
    }
}