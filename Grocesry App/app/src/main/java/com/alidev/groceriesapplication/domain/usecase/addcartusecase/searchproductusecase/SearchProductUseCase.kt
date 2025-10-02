package com.alidev.groceriesapplication.domain.usecase.addcartusecase.searchproductusecase

import com.alidev.groceriesapplication.data.Repository

class SearchProductUseCase(
    private val repository: Repository
) {

    operator fun invoke(query: String) = repository.searchProduct(query)

}