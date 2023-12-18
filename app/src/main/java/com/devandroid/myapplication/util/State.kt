package com.devandroid.myapplication.util

data class State<T>(
    val isLoading: Boolean = false,
    val data: List<T> = emptyList(),
    val response: T? = null,
    val error: String = ""
)
