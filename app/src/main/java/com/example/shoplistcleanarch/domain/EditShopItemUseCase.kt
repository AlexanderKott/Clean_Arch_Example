package com.example.shoplistcleanarch.domain

class EditShopItemUseCase(private val repo : ShopItemRepository) {

    fun editShopItem(item : ShopItem){
        repo.editShopItem(item)
    }
}