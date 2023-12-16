package com.devandroid.myapplication.presentation.screens.ListScreen.CryptoList

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.devandroid.myapplication.domain.model.CryptoModel
import com.devandroid.myapplication.util.formatToCurrency
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CryptoListItem(
    item: CryptoModel
) {
    val formatCurrency = formatToCurrency(item.price)
    Row (
        modifier = Modifier.wrapContentSize(Alignment.Center).fillMaxWidth().padding(32.dp)
    ) {
        AsyncImage(model = item.icon, contentDescription = item.name, contentScale = ContentScale.Crop)
        Column {
            Text(text = item.name, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 5.dp))
            Text(text = formatCurrency)
        }
    }
}