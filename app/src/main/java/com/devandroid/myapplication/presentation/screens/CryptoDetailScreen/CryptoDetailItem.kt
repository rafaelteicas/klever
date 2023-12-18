package com.devandroid.myapplication.presentation.screens.CryptoDetailScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.devandroid.myapplication.domain.model.CryptoDetailModel
import com.devandroid.myapplication.presentation.components.Text.Text
import com.devandroid.myapplication.util.formatToCurrency

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CryptoDetailItem( crypto: CryptoDetailModel, onClickItem: (crypto: CryptoDetailModel) -> Unit ) {
    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(model = crypto.image, contentDescription = "", modifier = Modifier.size(40.dp))
        Column (
            modifier = Modifier.padding(30.dp)
        ){
            Text(text = crypto.name)
            Text(text = formatToCurrency(crypto.price))
        }
    }
    Button(
        onClick = { onClickItem(crypto) }
        , modifier = Modifier.fillMaxSize())
    {
        Text(text = "Comprar")
    }
}


