package com.example.shoplistcleanarch.domain

import kotlinx.coroutines.flow.Flow

class GetListShopItemsUseCase(private val repo : ShopItemRepository) {

    fun getListShopItems(): Flow<List<ShopItem>> {
       return repo.getListShopItem()
    }
}