package com.alidev.groceriesapplication.domain.saveproductusecase

import com.alidev.groceriesapplication.data.Repository
import com.alidev.groceriesapplication.domain.ProductItem

class InsertProductsUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(products: List<ProductItem>) = repository.insertProducts(products)

}