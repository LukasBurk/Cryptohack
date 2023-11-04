package com.example.cryptohack.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cryptohack.network.Asset
import com.example.cryptohack.network.CryptoCurrency
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AssetsViewModel : ViewModel() {
    private val assetService = Asset

    private val _response = MutableStateFlow(
        listOf<CryptoCurrency>()
    )
    val response = _response.asStateFlow()

    fun loadData() {
        val scope = CoroutineScope(Job() + Dispatchers.IO)
        try {
            scope.launch {
                val res = assetService.assetService.getAllAssets().data
                println(res)
                _response.value = res
            }
        } catch (err: Error) {
            println(err)
        }
    }
}