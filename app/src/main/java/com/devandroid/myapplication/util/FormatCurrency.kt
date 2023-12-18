package com.devandroid.myapplication.util

import java.text.NumberFormat
import java.util.Locale

fun formatToCurrency(value: Number): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    return formatter.format(value)
}