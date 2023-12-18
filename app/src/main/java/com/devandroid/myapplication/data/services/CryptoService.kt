package com.devandroid.myapplication.data.services

import com.devandroid.myapplication.data.dto.CryptoDetailDto
import com.devandroid.myapplication.data.dto.CryptoDto
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CryptoService {
    @GET("coins/markets")
    suspend fun getList(
        @Query("vs_currency")
        vs_currency: String,
        @Query("order")
        order: String,
        @Query("per_page")
        per_page: Int,
        @Query("page")
        page: Int,
        @Query("sparkline")
        sparkline: Boolean,
    ): List<CryptoDto>

    @GET("coins/{id}")
    suspend fun getCryptoDetail(
        @Path("id")
        id: String
    ): CryptoDetailDto
}