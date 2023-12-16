package com.devandroid.myapplication.presentation.screens.ListScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.devandroid.myapplication.presentation.screens.ListScreen.CryptoList.CryptoListItem
import com.devandroid.myapplication.presentation.screens.ListScreen.CryptoList.CryptoListViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ListScreen (
    navController: NavController,
    viewModel: CryptoListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    LazyColumn(){
        items(state.data) {
            item ->
                CryptoListItem(item = item)
        }
    }
}