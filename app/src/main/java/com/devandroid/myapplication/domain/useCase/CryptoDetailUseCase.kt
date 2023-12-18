package com.devandroid.myapplication.domain.useCase

import com.devandroid.myapplication.domain.adapter.toCrypto
import com.devandroid.myapplication.domain.model.CryptoDetailModel
import com.devandroid.myapplication.domain.repository.CryptoRepository
import com.devandroid.myapplication.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptoDetailUseCase @Inject constructor(
    private val repository: CryptoRepository
){
    operator fun invoke(id: String): Flow<Response<CryptoDetailModel>> = flow {
        emit(Response.Loading())
        try {
            val response = repository.getCryptoDetail(id).toCrypto()
            emit(Response.Success(response))
        } catch (e: HttpException) {
            emit(Response.Error( e.message?: "Erro"))
        } catch (e: IOException) {
            emit(Response.Error(e.message?: "Erro"))
        }
    }
}