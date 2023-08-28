package com.example.mvvm_room_app.di.modules

import com.example.mvvm_room_app.repository.local.db.ProductDatabase
import org.koin.dsl.module

class DaoModule {
    val module = module {
        single { get<ProductDatabase>().productDao() }
    }
}