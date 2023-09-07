package com.example.shoplistcleanarch.domain

class GetShopItemUseCase(private val repo: ShopItemRepository) {

    fun getShopItem(id: Int): ShopItem {
        return repo.getShopItem(id)
    }
}