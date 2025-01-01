package com.artemchen.android.apodcompose.data

import com.artemchen.android.apodcompose.network.ApodApiService
import com.artemchen.android.apodcompose.network.Item

interface ApodPhotosRepository {
    suspend fun getApodLatestPhoto(): Item
    suspend fun getApodPhotos(startDate: String, endDate: String): List<Item>
}

class NetworkApodPhotosRepository(
    private val apodApiService: ApodApiService
) : ApodPhotosRepository {
    override suspend fun getApodLatestPhoto(): Item = apodApiService.getLatestPhoto()

    override suspend fun getApodPhotos(
        startDate: String, endDate: String
    ): List<Item> = apodApiService.getPhotos(startDate, endDate)
}