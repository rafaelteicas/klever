package com.devandroid.myapplication.data.repository

import com.devandroid.myapplication.data.dto.CryptoDto
import com.devandroid.myapplication.data.services.CryptoService
import com.devandroid.myapplication.domain.repository.CryptoRepository
import dagger.Provides
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoService: CryptoService
) : CryptoRepository {
    override suspend fun getList(): List<CryptoDto> {
        return cryptoService.getList()
    }
}