package com.artemchen.android.apodcompose.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artemchen.android.apodcompose.data.Item

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<Item>)

    @Query("SELECT * FROM items")
    suspend fun getAllItems(): List<Item>

    @Query("SELECT * FROM items ORDER BY id")
    fun getPagingItems(): PagingSource<Int, Item>

    @Query("DELETE FROM items")
    suspend fun deleteAllItems()
}