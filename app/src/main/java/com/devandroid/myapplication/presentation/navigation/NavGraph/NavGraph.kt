package com.devandroid.myapplication.presentation.navigation.NavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devandroid.myapplication.presentation.screens.CryptoDetailScreen.CryptoDetailScreen
import com.devandroid.myapplication.presentation.screens.SplashScreen.SplashScreen
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList.AddWalletScreen
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList.ListWalletScreen
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList.UpdateWalletScreen
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList.WalletViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    walletViewModel: WalletViewModel
) {
    NavHost(navController = navController, startDestination = NavScreens.AddWallet.route) {
        composable(
            route = NavScreens.AddWallet.route
        ) {
            ListWalletScreen(navController, walletViewModel)
        }
        composable(
            route = "${NavScreens.UpdateWaller.route}/{id}/{balance}"
        ) {
            val id = it.arguments?.getString("id")
            val balance = it.arguments?.getString("balance")
            UpdateWalletScreen(navController, walletViewModel, balance ?: "" , id ?: "")
        }
    }
}