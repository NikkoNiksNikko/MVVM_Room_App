package com.example.mvvm_room_app.repository.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm_room_app.models.`object`.Product
import com.example.mvvm_room_app.repository.local.dao.ProductDao

@Database(entities = [Product::class], version = 8, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}