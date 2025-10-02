package com.alidev.groceriesapplication.domain.getselectedproduct

import com.alidev.groceriesapplication.data.Repository
import com.alidev.groceriesapplication.domain.ProductItem
class GetSelectedProductUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productId: Int): ProductItem {
        return repository.getSelectedProduct(productId = productId)
    }

}