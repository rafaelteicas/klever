package com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList

import com.devandroid.myapplication.domain.model.WalletModel

data class WalletState(
    val isLoading: Boolean = false,
    val data: List<WalletModel> = emptyList(),
    val error: String = ""
)