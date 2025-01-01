package com.artemchen.android.apodcompose.data

import androidx.paging.PagingSource
import com.artemchen.android.apodcompose.database.ItemDao

interface ApodDatabaseRepository {
    suspend fun insert(items: List<Item>)

    suspend fun getAllItems(): List<Item>

    fun getPagingItems(): PagingSource<Int, Item>

    suspend fun deleteAllItems()
}

class OfflineApodRepository(private val itemDao: ItemDao) : ApodDatabaseRepository {
    override suspend fun insert(items: List<Item>) = itemDao.insert(items)

    override suspend fun getAllItems(): List<Item> = itemDao.getAllItems()

    override fun getPagingItems(): PagingSource<Int, Item> = itemDao.getPagingItems()

    override suspend fun deleteAllItems() = itemDao.deleteAllItems()
}