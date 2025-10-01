package com.alidev.groceriesapplication.presentation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alidev.groceriesapplication.domain.ProductItem
import com.alidev.groceriesapplication.domain.usecase.saveonboarding.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _productList = MutableStateFlow<List<ProductItem>>(emptyList())
    val productList = _productList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllProductUseCase.invoke().collect { value ->
                _productList.value = value
            }
        }
    }

    fun addCart(productItem: ProductItem) = viewModelScope.launch {
        useCases.addCartUseCase.invoke(productItem)
    }


}