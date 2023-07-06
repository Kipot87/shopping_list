package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ShopListDao {

    @Query("SELECT * FROM shop_items")
    fun getShopItemList(): LiveData<List<ShopItemDbModel>>

    @Query("SELECT * FROM shop_items WHERE id=:shopItemId LIMIT 1")
    fun getShopItem(shopItemId: Int): ShopItemDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShopItem(shopItemDbModel: ShopItemDbModel)

    @Query("DELETE FROM shop_items WHERE id=:shopItemId")
    fun deleteShopItem(shopItemId: Int)
}