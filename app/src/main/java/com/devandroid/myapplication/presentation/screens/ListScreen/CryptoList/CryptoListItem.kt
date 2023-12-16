package com.devandroid.myapplication.presentation.screens.ListScreen.CryptoList

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.devandroid.myapplication.domain.model.CryptoModel

@Composable
fun CryptoListItem(
    item: CryptoModel
) {
    Text(text = item.name)
}