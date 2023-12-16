package com.devandroid.myapplication.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.devandroid.myapplication.presentation.screens.HomeScreen.HomeScreen
import com.devandroid.myapplication.presentation.screens.ListScreen.ListScreen
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomTabNav() {
    val items = listOf<BottomScreens>(
        BottomScreens.HomeScreen,
        BottomScreens.ListScreen
    )
    val navController = rememberNavController()
    Scaffold (
        bottomBar = { BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            items.forEach { item ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                    label = { Text(text = item.label) },
                    alwaysShowLabel = false,
                    onClick = { navController.navigate(item.route) },
                    selectedContentColor = Color.DarkGray,
                    icon = { Icon(item.icon , contentDescription = null) })
            }
        } }
    ) {
        it ->
        NavHost(navController = navController, startDestination = BottomScreens.HomeScreen.route, Modifier.padding(it) ) {
            composable(BottomScreens.HomeScreen.route) { HomeScreen(navController = navController) }
            composable(BottomScreens.ListScreen.route) { ListScreen(navController = navController) }

        }
    }
}