package com.devandroid.myapplication.domain.repository

import com.devandroid.myapplication.domain.model.WalletModel

interface WalletRepository {
    suspend fun getList(): List<WalletModel>
}