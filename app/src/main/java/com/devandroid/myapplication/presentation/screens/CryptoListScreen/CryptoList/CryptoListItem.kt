package com.devandroid.myapplication.presentation.screens.CryptoListScreen.CryptoList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.devandroid.myapplication.domain.model.CryptoModel
import com.devandroid.myapplication.presentation.components.Text.Text
import com.devandroid.myapplication.util.formatToCurrency

@Composable
fun CryptoListItem(
    item: CryptoModel,
    onClickItem: (CryptoModel) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Box(
                    modifier = Modifier.padding(10.dp)
                    .size(55.dp)
                    .clip(RoundedCornerShape(18.dp)).background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = item.icon,
                        contentDescription = item.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column {
                        Text(
                            text = item.symbol.uppercase(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = item.name,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = formatToCurrency(item.price),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = formatToCurrency(item.priceVariation),
                                color =
                                if (item.priceVariation.toDouble() < 0) {
                                    Color.Red
                                } else if(item.priceVariation == 0) {
                                    Color.White
                                }
                                else {
                                    Color.Green
                                },
                            fontSize = 12.sp
                        )
                    }
                    Button(
                        onClick =  {
                            onClickItem(item)
                        }
                    ) { Text(text = "Comprar", fontSize = 12.sp) }
                }
            }
    }
}