package com.devandroid.myapplication.presentation.screens.HomeScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun HomeScreen(
    navController: NavController
) {
    Text(text = "Home")
}
