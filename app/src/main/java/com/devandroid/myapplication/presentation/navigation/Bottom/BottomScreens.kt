package com.devandroid.myapplication.presentation.navigation.Bottom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CurrencyBitcoin
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreens(val route: String, val label: String = "", val icon: ImageVector = Icons.Default.Home) {
    object HomeScreen : BottomScreens("HomeScreen", label = "Home", icon  = Icons.Default.Wallet)
    object AddWalletScreen : BottomScreens("AddWalletScreen", label = "Add", icon  = Icons.Default.Add)

    object ListScreen : BottomScreens("ListScreen", label = "List", icon  = Icons.Default.CurrencyBitcoin)

}