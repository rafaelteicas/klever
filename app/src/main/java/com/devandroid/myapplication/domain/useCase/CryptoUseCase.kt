package com.devandroid.myapplication.domain.useCase

import com.devandroid.myapplication.domain.adapter.toCrypto
import com.devandroid.myapplication.domain.model.CryptoModel
import com.devandroid.myapplication.domain.repository.CryptoRepository
import com.devandroid.myapplication.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptoUseCase @Inject constructor(
    private val repository: CryptoRepository
){
    operator fun invoke(): Flow<Response<List<CryptoModel>>> = flow {
        emit(Response.Loading())
        try {
            val data = repository.getList().map { it.toCrypto() }
            emit(Response.Success(data))
        } catch (e: HttpException) {
            emit(Response.Error( e.message?: "Erro"))
        } catch (e: IOException) {
            emit(Response.Error(e.message?: "Erro"))
        }
    }
}