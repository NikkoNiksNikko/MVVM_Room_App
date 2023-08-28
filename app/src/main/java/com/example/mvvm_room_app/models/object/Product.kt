package com.example.mvvm_room_app.models.`object`

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val productName: String? = "",
    @ColumnInfo(name = "description") val productDescription: String? = ""
)
