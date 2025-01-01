package com.artemchen.android.apodcompose.data

import com.artemchen.android.apodcompose.network.ApodApiService

interface ApodNetworkRepository {
    suspend fun getApodLatestPhoto(): Item
    suspend fun getApodPhotos(startDate: String, endDate: String): List<Item>
}

class OnlineApodRepository(private val apodApiService: ApodApiService) : ApodNetworkRepository {

    override suspend fun getApodLatestPhoto(): Item = apodApiService.getLatestPhoto()

    override suspend fun getApodPhotos(
        startDate: String, endDate: String
    ): List<Item> = apodApiService.getPhotos(startDate, endDate)
}