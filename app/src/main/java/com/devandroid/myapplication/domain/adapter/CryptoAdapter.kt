package com.devandroid.myapplication.domain.adapter

import com.devandroid.myapplication.data.dto.CryptoDto
import com.devandroid.myapplication.domain.model.CryptoModel

fun CryptoDto.toCrypto(): CryptoModel {
    return CryptoModel(
        id = id,
        name = name,
        icon = image,
        price = current_price
    )
}