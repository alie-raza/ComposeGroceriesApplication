package com.alidev.groceriesapplication.domain.usecase.saveonboarding

import com.alidev.groceriesapplication.domain.addcartusecase.AddCartUseCase
import com.alidev.groceriesapplication.domain.getallproduct.GetAllProductUseCase
import javax.inject.Inject

data class UseCases @Inject constructor(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
//    val insertProductsUseCase: InsertProductsUseCase,
//    val readOnBoardingUseCase: ReadOnBoardingUseCase,
//    val getSelectedProductUseCase: GetSelectedProductUseCase,
    val getAllProductUseCase: GetAllProductUseCase,
//    val getAllCartUseCase: GetAllCartUseCase,
    val addCartUseCase: AddCartUseCase,
//    val deleteCart: DeleteCartUseCase,
//    val searchProductUseCase: SearchProductUseCase
)