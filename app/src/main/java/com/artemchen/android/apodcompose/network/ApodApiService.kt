package com.artemchen.android.apodcompose.network

import com.artemchen.android.apodcompose.data.Item
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApiService {
    @GET("apod")
    suspend fun getLatestPhoto(): Item

    @GET("apod")
    suspend fun getPhotos(@Query("start_date") startDate: String,
                          @Query("end_date") endDate: String): List<Item>
}