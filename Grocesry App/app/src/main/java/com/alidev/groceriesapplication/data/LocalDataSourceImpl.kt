package com.alidev.groceriesapplication.data

import com.alidev.groceriesapplication.domain.LocalDataSource
import com.alidev.groceriesapplication.domain.ProductItem
import com.alidev.groceriesapplication.local.ProductDatabase
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    productDatabase: ProductDatabase
) : LocalDataSource {

    private val productDao = productDatabase.productDao()

    override suspend fun insertProducts(products: List<ProductItem>) =
        productDao.insertProducts(products)

    override fun getAllProduct(): Flow<List<ProductItem>> = productDao.getAllProducts()

    override suspend fun getSelectedProduct(productId: Int): ProductItem =
        productDao.getSelectedProduct(productId = productId)

    override fun getAllProductCart(isCart: Boolean): Flow<List<ProductItem>> =
        productDao.getAllProductCart(isCart)

    override suspend fun addCart(productItem: ProductItem) = productDao.addCart(productItem)

    override suspend fun deleteCart(productItem: ProductItem) {
        productItem.isCart = false
        productDao.deleteCart(productItem)
    }

    override fun searchProduct(query: String): Flow<List<ProductItem>> =
        productDao.searchProduct(query)

}