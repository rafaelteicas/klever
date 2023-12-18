package com.devandroid.myapplication.domain.repository

import com.devandroid.myapplication.data.dto.CryptoDetailDto
import com.devandroid.myapplication.data.dto.CryptoDto

interface CryptoRepository {
    suspend fun getList(): List<CryptoDto>
    suspend fun getCryptoDetail(id: String): CryptoDetailDto
}