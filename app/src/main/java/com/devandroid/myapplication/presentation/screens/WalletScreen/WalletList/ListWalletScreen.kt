package com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.RestoreFromTrash
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.devandroid.myapplication.presentation.components.Logo.Logo
import com.devandroid.myapplication.presentation.components.Text.Text
import com.devandroid.myapplication.presentation.navigation.NavGraph.NavScreens
import com.devandroid.myapplication.util.formatToCurrency

@SuppressLint("UnrememberedMutableState")
@Composable
fun ListWalletScreen(
    navController: NavController,
    viewModel: WalletViewModel
) {
    Logo()
    val firestoreData by remember { viewModel.firestoreData }
    LaunchedEffect(Unit) {
        viewModel.getData()
    }
    Column (
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .height(100.dp)
                .border(3.dp, Color.Gray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val somaBalance = firestoreData.sumOf { it.balance.toInt() }
            Text(text = "Seu saldo todal", fontSize = 15.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Wallet,
                    contentDescription = "Wallet",
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Text(
                    text = formatToCurrency(somaBalance.toDouble()),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
        }
        LazyColumn(
        ) {
            items(firestoreData) {
                val token = it.token
                val balance = it.balance
                val id = it.id
                Column(
                    modifier = Modifier.padding(vertical = 20.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Token: ")
                        Text(text = token)
                        Icon(
                            imageVector = Icons.Default.Edit,
                            tint = Color.White,
                            modifier = Modifier
                                .size(15.dp)
                                .offset(x = 10.dp)
                                .clickable { navController.navigate("${NavScreens.UpdateWaller.route}/${id}/${balance}") },
                            contentDescription = "Wallet",
                        )
                    }
                }
                Row {
                    Text(text = "Balance: ")
                    Text(
                        text = formatToCurrency(balance.toDouble()),
                        modifier = Modifier.weight(1f)
                    )
                    Icon(imageVector = Icons.Default.RestoreFromTrash,
                        tint = Color.Red,
                        contentDescription = "Wallet",
                        modifier = Modifier.clickable {
                            viewModel.removeData(it.id ?: "", viewModel.getData())
                        }
                    )

                }
                Divider(
                    color = Color.White,
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}



