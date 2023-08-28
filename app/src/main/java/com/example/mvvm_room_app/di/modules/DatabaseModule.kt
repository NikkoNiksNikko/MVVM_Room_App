package com.example.mvvm_room_app.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_room_app.repository.local.dao.ProductDao
import com.example.mvvm_room_app.repository.local.db.ProductDatabase
import org.koin.androidx.compose.get
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

class DatabaseModule {
    val modules = module {
        single {
            Room.databaseBuilder(
                get(),
                ProductDatabase::class.java,"product_database")
                .fallbackToDestructiveMigration()
                .build()
        }
    }

//    private fun provideRoomDatabase(applicationContext: Context) : RoomDatabase {
//        val db = Room.databaseBuilder(
//            applicationContext,
//            ProductDatabase::class.java,
//            "product_database"
//        ).build()
//
//        return db
//    }
}