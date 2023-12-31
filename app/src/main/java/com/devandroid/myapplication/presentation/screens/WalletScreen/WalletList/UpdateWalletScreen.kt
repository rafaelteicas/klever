package com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devandroid.myapplication.domain.model.WalletModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateWalletScreen(
    navController: NavController,
    walletViewModel: WalletViewModel,
    balance: String,
    id: String = "",
) {
    var balance : String by remember {
        mutableStateOf(balance)
    }

    val context = LocalContext.current

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = balance,
                onValueChange = { balance = it },
                label = { Text(text = "Altere o valor:")},
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                maxLines = 1
            )
            Button(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                onClick = {
                    walletViewModel.editData(
                        id,
                        balance
                    )
                    navController.popBackStack()
                }
            ) {
                Text(text = "Editar")
            }
        }
    }
}