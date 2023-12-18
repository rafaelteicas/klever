package com.devandroid.myapplication.presentation.navigation.NavGraph

sealed class NavScreens (val route: String) {
    object SplashScreen: NavScreens(route="SplashScreen")

    object AddWallet: NavScreens(route = "AddWallet")
    object UpdateWaller: NavScreens(route = "UpdateWaller")
    object CryptoDetail: NavScreens(route = "CryptoDetail")

}