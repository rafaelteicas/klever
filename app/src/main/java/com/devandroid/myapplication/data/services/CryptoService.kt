package com.devandroid.myapplication.data.services

import com.devandroid.myapplication.data.dto.CryptoDto
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface CryptoService {
    @GET("coins/markets?vs_currency=usd&order=market_cap_desc&per_page=10&page=1&sparkline=false")
    suspend fun getList(): List<CryptoDto>
}