package com.example.shoplistcleanarch.data

import com.example.shoplistcleanarch.domain.ShopItem
import com.example.shoplistcleanarch.domain.ShopItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ShopItemRepositoryImpl : ShopItemRepository {

    private val list = mutableListOf<ShopItem>()
    private val innerFlow = MutableStateFlow<List<ShopItem>>(listOf())
    private val repoScope = CoroutineScope(Dispatchers.Default)

    private fun updateData() {
        repoScope.launch { innerFlow.emit(list) }
    }
    override fun addShopItem( name : String, checked : Boolean, amount : Int ) : Int {
        list.add(ShopItem(id = list.size, name = name, checked = checked, amount = amount ))
        updateData()
        return list.size - 1
    }

    override fun deleteShopItem(id: Int) {
        list.removeAt(id)
        updateData()
    }

    override fun editShopItem(item: ShopItem) {
       val tempId = item.id
        list[tempId] = item
        updateData()
    }

    override fun getListShopItem(): Flow<List<ShopItem>> = flow {
        innerFlow.collect{
            emit(list.toList())
        }
    }

    override fun getShopItem(id: Int): ShopItem {
        return list.firstOrNull { it.id == id } ?: error("No such element")
    }
}