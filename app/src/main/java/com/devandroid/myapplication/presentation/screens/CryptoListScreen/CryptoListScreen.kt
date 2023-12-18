package com.devandroid.myapplication.presentation.screens.CryptoListScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devandroid.myapplication.presentation.components.Logo.Logo
import com.devandroid.myapplication.presentation.navigation.NavGraph.NavScreens
import com.devandroid.myapplication.presentation.screens.CryptoListScreen.CryptoList.CryptoListItem
import com.devandroid.myapplication.presentation.screens.CryptoListScreen.CryptoList.CryptoListViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CryptoListScreen (
    navController: NavController,
    viewModel: CryptoListViewModel = hiltViewModel()
) {
    Column {
        Logo()
        val state = viewModel.state.collectAsState().value
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            contentAlignment = Alignment.Center
        ) {
            when {
                state.data.isNotEmpty() -> {
                    LazyColumn {
                        items(state.data) {
                                item -> CryptoListItem(item = item, onClickItem = {
                                    navController.navigate(NavScreens.CryptoDetail.route + "/${it.id}") }) }
                    }
                }
                state.error.isNotEmpty() -> {
                    if(state.error.isNotEmpty()) {
                        Text(text = "Erro")
                    }
                }
                state.isLoading -> {
                    CircularProgressIndicator()
                }
            }
        }
    }

}

