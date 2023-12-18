package com.devandroid.myapplication.presentation.navigation.Bottom

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.devandroid.myapplication.presentation.navigation.NavGraph.NavScreens
import com.devandroid.myapplication.presentation.screens.CryptoDetailScreen.CryptoDetailScreen
import com.devandroid.myapplication.presentation.screens.HomeScreen.HomeScreen
import com.devandroid.myapplication.presentation.screens.CryptoListScreen.CryptoListScreen
import com.devandroid.myapplication.presentation.screens.SplashScreen.SplashScreen
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList.AddWalletScreen
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomTabNav() {
    val items = listOf<BottomScreens>(
        BottomScreens.ListScreen,
        BottomScreens.WalletScreen,
    )
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold (
        bottomBar = { BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            items.forEach { item ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                    alwaysShowLabel = false,
                    onClick = { navController.navigate(item.route) },
                    selectedContentColor = Color.DarkGray,
                    icon = { Icon(item.icon , contentDescription = null) })
            }
        } }
    ) {
        it ->
        NavHost(navController = navController, startDestination = BottomScreens.ListScreen.route , Modifier.padding(it) ) {
            composable(BottomScreens.WalletScreen.route) { WalletScreen(navController) }
            composable(BottomScreens.ListScreen.route) { CryptoListScreen(navController) }
            composable(BottomScreens.AddWalletScreen.route + "/{token}/{price}") {
                val token = it.arguments?.getString("token")
                val price = it.arguments?.getString("price")
                AddWalletScreen(navController, token = token, price = price)
            }
            composable(NavScreens.CryptoDetail.route + "/{id}") { CryptoDetailScreen(navController) }
            composable(NavScreens.SplashScreen.route) { SplashScreen(navController, scaffoldState) }
        }
    }
}

