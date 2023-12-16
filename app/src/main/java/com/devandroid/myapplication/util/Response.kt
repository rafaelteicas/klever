package com.devandroid.myapplication.util

sealed class Response<T>(val data: T? = null, val message: String? = null ) {
    class Loading<T>(data: T? = null): Response<T>()
    class Success<T>(data: T): Response<T>(data)
    class Error<T>(message: String, data: T? = null): Response<T>(data,message)
}