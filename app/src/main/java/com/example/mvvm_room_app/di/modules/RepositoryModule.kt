package com.example.mvvm_room_app.di.modules

import com.example.mvvm_room_app.repository.local.LocalDatabaseRepository
import com.example.mvvm_room_app.repository.local.LocalRepository
import com.example.mvvm_room_app.repository.local.dao.ProductDao
import com.example.mvvm_room_app.repository.local.db.ProductDatabase
import org.koin.dsl.module

class RepositoryModule {
    val modules = module {
        single { provideLocalRepository(get()) }
    }

    private fun provideLocalRepository(database: ProductDao) : LocalRepository{
        return LocalDatabaseRepository(database)
    }
}