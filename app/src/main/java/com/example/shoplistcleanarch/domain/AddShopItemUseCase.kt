package com.example.shoplistcleanarch.domain

class AddShopItemUseCase(private val repo : ShopItemRepository) {

    fun addShopItem(name : String, checked : Boolean, amount : Int) : Int{
       return repo.addShopItem(name, checked, amount)
    }
}