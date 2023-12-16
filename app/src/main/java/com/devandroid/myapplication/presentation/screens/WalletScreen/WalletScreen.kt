package com.devandroid.myapplication.presentation.screens.WalletScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.devandroid.myapplication.domain.model.WalletModel
import com.devandroid.myapplication.presentation.screens.FormScreen.FormScreen

@Composable
fun WalletScreen(
    navController: NavController
) {
    val walletList = remember {
        mutableListOf<WalletModel>()
    }
    WalletItem(walletList)
}

@Composable
fun WalletItem(
    walletList: MutableList<WalletModel>
) {
    var token by remember {
        mutableStateOf("")
    }
    var balance by remember {
        mutableStateOf("")
    }
    var isEditing by remember {
        mutableStateOf(false)
    }
    var textButton by remember {
        mutableStateOf("Adicionar")
    }
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        FormScreen(
            token = token,
            funToken = { token = it },
            balance = balance,
            funBalance = { balance = it },
            isEditing = isEditing,
            funIsEditing = { isEditing = false },
            textButton = textButton,
            funTextButton = { textButton = it },
            walletList = walletList,
            funReset = {
                token = ""
                balance= ""
            }
        )
    }
    fun addWallet(token: String, balance: String, walletList: MutableList<WalletModel>) {
        walletList.add(WalletModel(token, balance))
    }
    fun updateWallet(token: String, balance: String, walletList: MutableList<WalletModel>) {
        walletList.forEach{
            item ->
            if(item.token == token){
                item.balance = balance
            }
        }
    }
    fun removeWallet(token: String, balance: String, walletList: MutableList<WalletModel>) {
        walletList.forEach { item ->
            if (item.token == token) {
                walletList.remove(item)
            }
        }
    }

}