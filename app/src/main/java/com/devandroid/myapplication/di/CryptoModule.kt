package com.devandroid.myapplication.di

import com.devandroid.myapplication.data.repository.CryptoRepositoryImpl
import com.devandroid.myapplication.data.services.CryptoService
import com.devandroid.myapplication.domain.repository.CryptoRepository
import com.devandroid.myapplication.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CryptoModule {
    @Provides
    @Singleton
    fun provideCryptoService(): CryptoService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoService::class.java)
    }
    @Provides
    @Singleton
    fun provideCryptoRepo(service: CryptoService): CryptoRepository {
        return CryptoRepositoryImpl(service)
    }
}