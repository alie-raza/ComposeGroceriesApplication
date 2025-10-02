package com.alidev.groceriesapplication.di

import android.content.Context
import com.alidev.groceriesapplication.data.OnBoardingOperationImpl
import com.alidev.groceriesapplication.data.Repository
import com.alidev.groceriesapplication.domain.OnBoardingOperations
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.AddCartUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.deletecartusecase.DeleteCartUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.getallcartusecase.GetAllCartUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.getallproduct.GetAllProductUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.saveproductusecase.InsertProductsUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.searchproductusecase.SearchProductUseCase
import com.alidev.groceriesapplication.domain.SaveOnBoardingUseCase
import com.alidev.groceriesapplication.domain.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context
    ): OnBoardingOperations = OnBoardingOperationImpl(context = context)

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            getAllProductUseCase = GetAllProductUseCase(repository),
            addCartUseCase = AddCartUseCase(repository),
            insertProductsUseCase = InsertProductsUseCase(repository),
            getAllCartUseCase = GetAllCartUseCase(repository),
            deleteCart = DeleteCartUseCase(repository),
            searchProductUseCase = SearchProductUseCase(repository)
        )
    }

}