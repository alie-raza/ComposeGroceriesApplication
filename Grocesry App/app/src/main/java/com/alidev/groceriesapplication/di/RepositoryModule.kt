package com.alidev.groceriesapplication.di
import android.content.Context
import com.alidev.groceriesapplication.data.OnBoardingOperationImpl
import com.alidev.groceriesapplication.data.Repository
import com.alidev.groceriesapplication.domain.OnBoardingOperations
import com.alidev.groceriesapplication.domain.addcartusecase.AddCartUseCase
import com.alidev.groceriesapplication.domain.getallproduct.GetAllProductUseCase
import com.alidev.groceriesapplication.domain.saveproductusecase.InsertProductsUseCase
import com.alidev.groceriesapplication.domain.usecase.saveonboarding.SaveOnBoardingUseCase
import com.alidev.groceriesapplication.domain.usecase.saveonboarding.UseCases
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
            insertProductsUseCase = InsertProductsUseCase(repository)
        )
    }

}