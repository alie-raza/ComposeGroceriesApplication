package com.alidev.groceriesapplication.domain.usecase.saveonboarding

import com.alidev.groceriesapplication.data.Repository
import javax.inject.Inject

class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(isCompleted: Boolean) {
        repository.saveOnBoardingState(isCompleted = isCompleted)
    }

}