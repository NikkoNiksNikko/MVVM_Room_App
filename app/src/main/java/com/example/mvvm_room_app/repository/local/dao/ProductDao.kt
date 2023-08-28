package com.example.mvvm_room_app.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_room_app.models.`object`.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM product_table")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product_table WHERE name LIKE '%' || :name || '%'")
    fun searchProductsByName(name: String): Flow<List<Product>>
}