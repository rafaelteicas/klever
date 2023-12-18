package com.devandroid.myapplication.presentation.screens.CryptoListScreen.CryptoList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devandroid.myapplication.domain.model.CryptoModel
import com.devandroid.myapplication.domain.useCase.CryptoUseCase
import com.devandroid.myapplication.util.Response
import com.devandroid.myapplication.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase
): ViewModel() {
    private val _state = MutableStateFlow(State<CryptoModel>())
    var state: StateFlow<State<CryptoModel>> = _state
    fun getCryptoList() {
        viewModelScope.launch(Dispatchers.IO) {
            cryptoUseCase().collect{
                when(it) {
                    is Response.Success -> _state.value = State(data = it.data ?: emptyList())
                    is Response.Loading ->_state.value = State(isLoading = true)
                    is Response.Error -> _state.value = State(error = it.message ?: "Error")
                }
            }
        }
    }
    init {
        getCryptoList()
    }
}