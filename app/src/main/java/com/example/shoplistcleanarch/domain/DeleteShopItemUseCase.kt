package com.example.shoplistcleanarch.domain

class DeleteShopItemUseCase(private val repo : ShopItemRepository) {

    fun deleteShopItem(id : Int){
        repo.deleteShopItem(id)
    }
}