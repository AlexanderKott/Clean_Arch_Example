package com.example.shoplistcleanarch

import com.example.shoplistcleanarch.data.ShopItemRepositoryImpl
import com.example.shoplistcleanarch.domain.AddShopItemUseCase
import com.example.shoplistcleanarch.domain.DeleteShopItemUseCase
import com.example.shoplistcleanarch.domain.GetListShopItemsUseCase
import com.example.shoplistcleanarch.domain.GetShopItemUseCase
import com.example.shoplistcleanarch.domain.ShopItem
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ExampleUnitTest {


    @Test
    fun `add items test`() = runBlocking {
        val repo = ShopItemRepositoryImpl()
        val t0 = AddShopItemUseCase(repo)
        val t2 = GetListShopItemsUseCase(repo)

        val items = t2.getListShopItems()
        t0.addShopItem("perviy", true, 555)

        val x1 = items.take(1).toList().toString()

        assertEquals(x1, "[[ShopItem(id=0, name=perviy, checked=true, amount=555)]]")

        t0.addShopItem("vtoroy", true, 555)

        val x2 = items.take(1).toList().toString()
        assertEquals(
            x2,
            "[[ShopItem(id=0, name=perviy, checked=true, amount=555), ShopItem(id=1, name=vtoroy, checked=true, amount=555)]]"
        )
    }


    @Test
    fun `delete items test`() = runBlocking {

        val repo = ShopItemRepositoryImpl()
        val t0 = AddShopItemUseCase(repo)
        val t2 = GetListShopItemsUseCase(repo)

        val items = t2.getListShopItems()

        val id = t0.addShopItem("perviy1", true, 555)

        val x1 = items.take(1).toList().toString()

        assertEquals(x1, "[[ShopItem(id=0, name=perviy1, checked=true, amount=555)]]")


        val t3 = DeleteShopItemUseCase(repo)
        t3.deleteShopItem(id)

        val x2 = items.take(1).toList().toString()

        assertEquals("[[]]", x2)

    }


    @Test
    fun `edit item test`() = runBlocking {

        val repo = ShopItemRepositoryImpl()
        val t0 = AddShopItemUseCase(repo)
        val t2 = GetShopItemUseCase(repo)

        val id = t0.addShopItem("bulka", true, 777)

        val result = t2.getShopItem(id).toString()

        assertEquals("ShopItem(id=0, name=bulka, checked=true, amount=777)", result)

    }

}