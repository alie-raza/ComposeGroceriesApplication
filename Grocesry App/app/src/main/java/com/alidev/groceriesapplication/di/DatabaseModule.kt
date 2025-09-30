package com.alidev.groceriesapplication.di

import android.content.Context
import androidx.room.Room
import com.alidev.groceriesapplication.data.LocalDataSourceImpl
import com.alidev.groceriesapplication.domain.LocalDataSource
import com.alidev.groceriesapplication.local.ProductDatabase
import com.alidev.groceriesapplication.utils.Constants.PRODUCT_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            PRODUCT_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: ProductDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(database)
    }

}