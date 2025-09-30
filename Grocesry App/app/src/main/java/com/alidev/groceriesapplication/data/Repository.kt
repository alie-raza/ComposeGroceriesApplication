package com.alidev.groceriesapplication.data

import com.alidev.groceriesapplication.domain.LocalDataSource
import com.alidev.groceriesapplication.domain.OnBoardingOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: OnBoardingOperations,
    private val localDataSource: LocalDataSource
) {

    suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.saveOnBoardingState(isCompleted = isCompleted)
    }

    fun readOnBoardingState(): Flow<Boolean> = dataStore.readOnBoardingState()


}