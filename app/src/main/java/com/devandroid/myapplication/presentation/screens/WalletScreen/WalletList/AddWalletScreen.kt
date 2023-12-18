package com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devandroid.myapplication.domain.model.WalletModel
import com.devandroid.myapplication.presentation.components.Logo.Logo
import com.devandroid.myapplication.presentation.components.Text.Text
import com.devandroid.myapplication.presentation.navigation.Bottom.BottomScreens
import com.devandroid.myapplication.util.formatToCurrency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWalletScreen(
    navController: NavController,
    walletViewModel: WalletViewModel = hiltViewModel(),
    token: String? = "",
    price: String? = ""
) {
    Log.d("price ", "$price")
    var balance : String by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val value = formatToCurrency(balance.toIntOrNull() ?: 0 * price?.toDouble()!!)
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Arrow",
            modifier = Modifier.padding(horizontal = 30.dp).clickable { navController.navigate(BottomScreens.ListScreen.route) }
        )
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "1 ${token?.uppercase() ?: ""} : ${formatToCurrency(price?.toDouble() ?: 0) ?: ""}", color = Color.Gray)
            Text(text = "Preço:")
            Text(text = "$value", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                value = balance,
                onValueChange = { balance =  it },
                label = { Text(text = "Insira o valor que deseja comprar: ")},
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                maxLines = 1
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp)
                    .padding(vertical = 32.dp, horizontal = 16.dp),
                onClick = {
                    val data = WalletModel(
                        token = token?.uppercase() ?: "",
                        balance = balance
                    )
                    if(token!!.isNotEmpty() && balance.isNotEmpty()) {
                        walletViewModel.saveData(data, context)
                        navController.navigate(BottomScreens.WalletScreen.route)
                    }
                }
            ) {
                Text(text = "Comprar", fontWeight = FontWeight.Bold)
            }
        }
    }
}