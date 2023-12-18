package com.devandroid.myapplication.data.dto

data class CryptoDetailDto(
    val additional_notices: List<Any>,
    val asset_platform_id: Any,
    val block_time_in_minutes: Int,
    val categories: List<String>,
    val community_data: Any,
    val country_origin: String,
    val description: Description,
    val detail_platforms: Any,
    val developer_data: Any,
    val genesis_date: String,
    val hashing_algorithm: String,
    val id: String,
    val image: Image,
    val last_updated: String,
    val links: Any,
    val localization: Any,
    val market_cap_rank: Int,
    val market_data: MarketData,
    val name: String,
    val platforms: Any,
    val preview_listing: Any,
    val public_notice: Any,
    val sentiment_votes_down_percentage: Double,
    val sentiment_votes_up_percentage: Double,
    val status_updates: List<Any>,
    val symbol: String,
    val tickers: List<Any>,
    val watchlist_portfolio_users: Int,
    val web_slug: String
)

data class Description(
    val en: String,
)

data class Image(
    val large: String,
)

data class MarketData(
    val current_price: CurrentPrice
)

data class CurrentPrice (
    val brl: Number
)