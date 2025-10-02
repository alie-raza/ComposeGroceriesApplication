package com.alidev.groceriesapplication.domain.deletecartusecase

import com.alidev.groceriesapplication.data.Repository
import com.alidev.groceriesapplication.domain.ProductItem

class DeleteCartUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productItem: ProductItem) = repository.deleteCart(productItem)

}