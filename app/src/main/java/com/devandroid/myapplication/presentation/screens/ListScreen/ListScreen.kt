package com.devandroid.myapplication.presentation.screens.ListScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    Box(
        modifier = Modifier.fillMaxSize().padding(top = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        }
        else {
            LazyColumn {
                items(state.data) {
                        item ->
                    CryptoListItem(item = item)
                }
            }
        }
    }

}