package com.devandroid.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import com.devandroid.myapplication.presentation.navigation.Bottom.BottomTabNav
import com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList.WalletViewModel
import com.devandroid.myapplication.presentation.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        MyApplicationTheme {
                BottomTabNav()
            }
        }
    }
}

