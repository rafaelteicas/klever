package com.devandroid.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.devandroid.myapplication.presentation.navigation.Bottom.BottomTabNav
import com.devandroid.myapplication.presentation.navigation.NavGraph.NavGraph
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList.WalletViewModel
import com.devandroid.myapplication.presentation.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.navigationBarColor = Color.Transparent.toArgb()
        setContent {
            MyApplicationTheme {
                Scaffold (
                    bottomBar = { BottomTabNav() }
                ) {

                }
            }
        }
    }
}

