package com.alidev.groceriesapplication.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alidev.groceriesapplication.domain.ProductItem
import com.alidev.groceriesapplication.local.dao.ProductDao

@Database(entities = [ProductItem::class], version = 2)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}