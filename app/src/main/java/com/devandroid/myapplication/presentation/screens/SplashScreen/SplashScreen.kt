package com.devandroid.myapplication.presentation.screens.SplashScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devandroid.myapplication.presentation.components.Logo.Logo
import com.devandroid.myapplication.presentation.navigation.Bottom.BottomScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    scaffoldState: ScaffoldState
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate(BottomScreens.ListScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Logo()
    }
}