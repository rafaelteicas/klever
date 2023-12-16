package com.devandroid.myapplication.presentation.screens.WalletScreen.WalletList

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devandroid.myapplication.domain.model.WalletModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class WalletViewModel(): ViewModel() {

    fun saveData(
        data: WalletModel,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore.collection("wallet")
        try {
            fireStoreRef.add(data).await()
            showToast(context, "Sucesso")
        } catch (e: Exception) {
            val errorMessage = e.message ?: "Erro ao adicionar"
            showToast(context, errorMessage)
        }
    }

    val firestoreData = mutableStateOf<List<WalletModel>>(emptyList())
    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        val db = FirebaseFirestore.getInstance()
        val fireStoreRef = db.collection("wallet")
        val dataList = mutableListOf<WalletModel>()
        fireStoreRef.get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val data = document.data
                    val walletData = WalletModel(
                        token = data["token"] as String ?: "",
                        balance = data["balance"] as String ?: "",
                        id = document.id
                    )
                    Log.d("firestore data", "$walletData")
                    dataList.add(walletData)
                }
                firestoreData.value = dataList
            }

    }

    fun removeData(id: String, update: Job) {
        val db = FirebaseFirestore.getInstance()
        val fireStoreRef = db.collection("wallet").document(id)
        fireStoreRef.delete().addOnSuccessListener {
            update
        }
    }

    fun editData(id:String, balance: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection("wallet").document(id).update("balance", balance)
    }
}
private suspend fun showToast(context: Context, message: String) {
    withContext(Dispatchers.Main) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
