package com.devandroid.myapplication.presentation.screens.WalletScreen

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devandroid.myapplication.presentation.navigation.NavGraph.NavGraph
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList.WalletViewModel
import com.google.firebase.firestore.FirebaseFirestore



@Composable
fun WalletScreen(
    navController: NavController,
    walletViewModel: WalletViewModel = viewModel()
) {
    NavGraph(navController = rememberNavController(), walletViewModel = walletViewModel)
}
