package com.devandroid.myapplication.domain.model

data class CryptoModel (
    val id: String,
    val name: String,
    val icon: String,
    val price: Number,
    val symbol: String,
    val priceVariation: Number
)
