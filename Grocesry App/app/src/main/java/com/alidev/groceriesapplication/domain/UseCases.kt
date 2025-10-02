package com.alidev.groceriesapplication.domain

import com.alidev.groceriesapplication.domain.usecase.addcartusecase.AddCartUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.deletecartusecase.DeleteCartUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.getallcartusecase.GetAllCartUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.getallproduct.GetAllProductUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.saveproductusecase.InsertProductsUseCase
import com.alidev.groceriesapplication.domain.usecase.addcartusecase.searchproductusecase.SearchProductUseCase
import javax.inject.Inject

data class UseCases @Inject constructor(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val insertProductsUseCase: InsertProductsUseCase,
//    val readOnBoardingUseCase: ReadOnBoardingUseCase,
//    val getSelectedProductUseCase: GetSelectedProductUseCase,
    val getAllProductUseCase: GetAllProductUseCase,
    val getAllCartUseCase: GetAllCartUseCase,
    val addCartUseCase: AddCartUseCase,
    val deleteCart: DeleteCartUseCase,
    val searchProductUseCase: SearchProductUseCase
)