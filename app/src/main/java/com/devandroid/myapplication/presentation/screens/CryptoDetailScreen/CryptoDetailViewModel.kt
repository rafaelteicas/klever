package com.devandroid.myapplication.presentation.screens.CryptoDetailScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devandroid.myapplication.domain.model.CryptoDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.devandroid.myapplication.domain.model.CryptoModel
import com.devandroid.myapplication.domain.useCase.CryptoDetailUseCase
import com.devandroid.myapplication.util.Response
import com.devandroid.myapplication.util.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val cryptoDetailUseCase: CryptoDetailUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(State<CryptoDetailModel>())
    val state: StateFlow<State<CryptoDetailModel>> = _state
    private  fun getCryptoDetail(id: String) =
        viewModelScope.launch (Dispatchers.IO) {
            cryptoDetailUseCase(id).collect{
                when (it) {
                    is Response.Success -> {
                        _state.value = State(response = it.data)
                        Log.d("STATE ", "${_state.value}")
                    }
                    is Response.Loading -> _state.value = State(isLoading = true)
                    is Response.Error -> _state.value = State(error = "ERROR")
                }
            }
    }
    init {
        savedStateHandle.get<String>("id")?.let { getCryptoDetail(it) }
    }
}