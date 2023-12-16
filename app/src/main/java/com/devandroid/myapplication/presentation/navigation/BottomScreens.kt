package com.devandroid.myapplication.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreens(val route: String, val label: String = "", val icon: ImageVector = Icons.Default.Home) {
    object HomeScreen : BottomScreens("HomeScreen", label = "Home", icon  = Icons.Default.Home)
    object WalletScreen : BottomScreens("WalletScreen", label = "Wallet", icon  = Icons.Default.Face)
    object ListScreen : BottomScreens("ListScreen", label = "List", icon  = Icons.Default.Menu)

}