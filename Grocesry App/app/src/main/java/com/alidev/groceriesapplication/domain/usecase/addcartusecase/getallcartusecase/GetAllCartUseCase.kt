package com.alidev.groceriesapplication.domain.usecase.addcartusecase.getallcartusecase

import com.alidev.groceriesapplication.data.Repository
import com.alidev.groceriesapplication.domain.ProductItem
import kotlinx.coroutines.flow.Flow

class GetAllCartUseCase(
    private val repository: Repository
) {

    operator fun invoke(isCart: Boolean): Flow<List<ProductItem>> =
        repository.getAllProductCart(isCart)

}