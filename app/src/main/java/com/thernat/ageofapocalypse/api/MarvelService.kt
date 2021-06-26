package com.thernat.ageofapocalypse.api

import com.thernat.ageofapocalypse.BuildConfig
import com.thernat.ageofapocalypse.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("comics?characters=1009156&dateRange=2020-01-01,2021-05-02")
    suspend fun getComics(
        @Query("ts") ts: String = System.currentTimeMillis().toString(),
        @Query("apikey")secret: String = BuildConfig.API_KEY,
        @Query("hash")hash: String = ApiHaspProvider.getHash(ts),
        ): ApiResponse
}