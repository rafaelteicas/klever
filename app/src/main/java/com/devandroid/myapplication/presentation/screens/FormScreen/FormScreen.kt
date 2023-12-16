package com.devandroid.myapplication.presentation.screens.FormScreen

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.devandroid.myapplication.domain.model.WalletModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    token: String,
    funToken: (String) -> Unit,
    balance: String,
    funBalance: (String) -> Unit,
    isEditing: Boolean,
    funIsEditing: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    walletList: MutableList<WalletModel>,
    funReset: () -> Unit,
) {
    OutlinedTextField(
        value = token, 
        onValueChange = {funToken(it)},
        label = { Text(text = "Token") },
        maxLines = 1,
        enabled = !isEditing
    )
    OutlinedTextField(
        value = balance,
        onValueChange = {funBalance(it)},
        label = { Text(text = "Token") },
        maxLines = 1,
        enabled = !isEditing
    )
    Button(
        onClick = {
            if(isEditing) {
                funTextButton("Adicionar")
                funIsEditing()
            } else {

            }
            funReset()
        }
    ) {
        Text(text = textButton)
    }
}