package com.devandroid.myapplication.presentation.navigation.NavGraph

sealed class NavScreens (val route: String) {

    object AddWallet: NavScreens(route = "AddWallet")
    object UpdateWaller: NavScreens(route = "UpdateWaller")

}