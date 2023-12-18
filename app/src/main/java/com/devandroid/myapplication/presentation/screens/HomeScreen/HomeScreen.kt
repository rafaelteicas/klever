package com.devandroid.myapplication.presentation.screens.HomeScreen

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devandroid.myapplication.presentation.navigation.NavGraph.NavGraph
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList.WalletViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    walletViewModel: WalletViewModel = viewModel()
    ) {
    NavGraph(navController = rememberNavController(), walletViewModel = walletViewModel)
}
