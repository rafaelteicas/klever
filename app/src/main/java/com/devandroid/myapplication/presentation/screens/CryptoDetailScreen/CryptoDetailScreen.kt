package com.devandroid.myapplication.presentation.screens.CryptoDetailScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devandroid.myapplication.presentation.components.Text.Text
import com.devandroid.myapplication.presentation.navigation.Bottom.BottomScreens

@SuppressLint("StateFlowValueCalledInComposition", "SuspiciousIndentation")
@Composable
fun CryptoDetailScreen(
   navController: NavController,
   cryptoDetailViewModel: CryptoDetailViewModel = hiltViewModel()
) {
   val state = cryptoDetailViewModel.state.collectAsState().value
   val item = state.response ?: return
   Icon(
      imageVector = Icons.Default.ArrowBack,
      contentDescription = "Arrow",
      modifier = Modifier.padding(30.dp).clickable { navController.popBackStack() })
   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(30.dp),
         contentAlignment = Alignment.Center
            ) {
               when {
                  state.response != null -> {
                     LazyColumn (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                     ) {
                        item {
                           CryptoDetailItem(crypto = item,
                              onClickItem = {
                                 navController.navigate(BottomScreens.AddWalletScreen.route + "/${item.symbol}/${item.price}")
                              })
                        }
                     }
                  }
                  state.error.isNotEmpty() -> {
                     if(state.error.isNotEmpty()) {
                        Text(text = "Erro")
                     }
                  }
                  state.isLoading -> {
                     CircularProgressIndicator()
                  }
         }
      }
   }

fun getFirstParagraph(text: String): String {
   return text.split("\n").firstOrNull() ?: ""
}