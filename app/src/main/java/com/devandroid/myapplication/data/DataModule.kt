package com.devandroid.myapplication.data

import com.devandroid.myapplication.data.repository.CryptoRepositoryImpl
import com.devandroid.myapplication.data.services.CryptoService
import com.devandroid.myapplication.util.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class DataModule {
    private inline fun createService(
        factory: Moshi
    ): CryptoService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(factory))
            .build()
            .create(CryptoService::class.java)
    }
    private fun dataModule(): Module {
        return module {
            single{ CryptoRepositoryImpl(get()) }
        }
    }
    private fun networkModule() : Module {
        return module {
            single { createService(get()) }
            single { Moshi.Builder().add(KotlinJsonAdapterFactory()).build() }
        }
    }
    fun load() {
        loadKoinModules(dataModule() + networkModule())
    }
}