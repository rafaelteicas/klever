package com.devandroid.myapplication.domain.adapter

import com.devandroid.myapplication.data.dto.CryptoDetailDto
import com.devandroid.myapplication.domain.model.CryptoDetailModel

fun CryptoDetailDto.toCrypto(): CryptoDetailModel {
    return CryptoDetailModel(
        id = id,
        name = name,
        description = description.en,
        rank = market_cap_rank,
        image = image.large,
        price = market_data.current_price.brl,
        symbol = symbol
    )
}