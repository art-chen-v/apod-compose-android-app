package com.artemchen.android.apodcompose.data

import android.util.Log
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

interface AppContainer {
    val apodNetworkRepository: ApodNetworkRepository
    val apodDatabaseRepository: ApodDatabaseRepository
}

class DefaultAppContainer {
    private val baseUrl = "https://api.nasa.gov/planetary/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
}