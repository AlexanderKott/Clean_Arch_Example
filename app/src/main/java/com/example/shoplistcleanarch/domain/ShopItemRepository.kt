package com.example.shoplistcleanarch.domain

import kotlinx.coroutines.flow.Flow

interface ShopItemRepository {

    fun addShopItem(name : String, checked : Boolean, amount : Int) : Int
    fun deleteShopItem(id : Int)
    fun editShopItem(item : ShopItem)
    fun getListShopItem(): Flow<List<ShopItem>>
    fun getShopItem(id: Int): ShopItem

}