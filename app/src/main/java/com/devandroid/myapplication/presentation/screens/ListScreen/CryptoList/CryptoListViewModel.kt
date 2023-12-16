package com.devandroid.myapplication.presentation.screens.ListScreen.CryptoList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devandroid.myapplication.presentation.useCase.CryptoUseCase
import com.devandroid.myapplication.util.Response
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
    private val _state = MutableStateFlow(CryptoState())
    var state: StateFlow<CryptoState> = _state
    fun getCryptoList() {
        viewModelScope.launch(Dispatchers.IO) {
            cryptoUseCase().collect{
                when(it) {
                    is Response.Success -> {
                        _state.value = CryptoState(data = it.data ?: emptyList())
                    }
                    is Response.Loading -> {
                        _state.value = CryptoState(isLoading = true)
                    }
                    is Response.Error -> {
                        _state.value = CryptoState(error = it.message ?: "Error")
                    }
                }
            }
        }
    }
    init {
        getCryptoList()
    }
}