package com.devandroid.myapplication.presentation.screens.ListScreen.CryptoList

import com.devandroid.myapplication.domain.model.CryptoModel

data class CryptoState(
    val isLoading: Boolean = false,
    val data: List<CryptoModel> = emptyList(),
    val error: String = ""
)
