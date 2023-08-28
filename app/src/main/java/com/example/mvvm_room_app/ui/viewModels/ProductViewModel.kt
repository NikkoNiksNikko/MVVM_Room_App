package com.example.mvvm_room_app.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_room_app.domain.RequestCallback
import com.example.mvvm_room_app.domain.interfaces.IProductUseCase
import com.example.mvvm_room_app.models.`object`.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ProductViewModel(private val useCase: IProductUseCase) : ViewModel() {

//    private val _products = MutableLiveData<List<Product>>()
//    val products: LiveData<List<Product>> = _products

//    fun loadAllProducts(){
//        viewModelScope.launch(Dispatchers.IO){
//            try {
//                useCase.getAllProducts().collect{
//                    _products.postValue(it)
//                }
//            }catch (e: Exception){
//                Log.i("ERROR: ","FAILED")
//            }
//        }
//    }

    // STATE FLOW
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    fun loadAllProducts(){
        viewModelScope.launch {
            useCase.getAllProducts(object : RequestCallback<List<Product>>{
                override fun onSuccess(data: List<Product>) {
                    _products.value = data
                }

                override fun onFail(throwable: Throwable) {
                }
            })
        }
    }

    fun insertNewProduct(product: Product, requestCallback: RequestCallback<Product>){
        viewModelScope.launch {
            useCase.insertNewProduct(product, object : RequestCallback<Product>{
                override fun onSuccess(data: Product) {
                    requestCallback.onSuccess(data)
                }

                override fun onFail(throwable: Throwable) {
                    requestCallback.onFail(throwable)
                }
            })
        }
    }

    fun searchProductsByName(name: String, requestCallback: RequestCallback<List<Product>>){
        viewModelScope.launch {
            useCase.searchProductsByName(name, object : RequestCallback<List<Product>>{
                override fun onSuccess(data: List<Product>) {
                    _products.value = data
                    requestCallback.onSuccess(data)
                }

                override fun onFail(throwable: Throwable) {
                    requestCallback.onFail(throwable)
                }
            })
        }
    }
}