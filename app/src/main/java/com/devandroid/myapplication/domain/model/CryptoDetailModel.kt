package com.devandroid.myapplication.domain.model

data class CryptoDetailModel (
    val id: String,
    val name: String,
    val description: String,
    val rank: Number,
    val image: String,
    val price: Number,
    val symbol: String
)