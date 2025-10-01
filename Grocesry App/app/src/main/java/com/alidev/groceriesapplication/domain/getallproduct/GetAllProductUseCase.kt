package com.alidev.groceriesapplication.domain.getallproduct

import com.alidev.groceriesapplication.data.Repository
import com.alidev.groceriesapplication.domain.ProductItem
import kotlinx.coroutines.flow.Flow

class GetAllProductUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<List<ProductItem>> = repository.getAllProduct()

}