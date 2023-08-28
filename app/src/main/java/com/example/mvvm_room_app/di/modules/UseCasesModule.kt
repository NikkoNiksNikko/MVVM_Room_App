package com.example.mvvm_room_app.di.modules

import com.example.mvvm_room_app.domain.interfaces.IProductUseCase
import com.example.mvvm_room_app.domain.usecases.ProductUseCase
import org.koin.dsl.module

class UseCasesModule {
    val modules = module {
        single<IProductUseCase>{ ProductUseCase(get()) }
    }
}