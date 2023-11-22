package com.example.cryptohack.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import com.example.cryptohack.network.Asset
import com.example.cryptohack.network.CryptoCurrency
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class SortBy {
    Price, MarketCap, Rank
}
class AssetsViewModel : ViewModel() {
    private val assetService = Asset

    private var _sortBy = SortBy.Rank

    private val _response = MutableStateFlow(
        listOf<CryptoCurrency>()
    )
    val response = _response.asStateFlow()

    fun loadData() {
        val scope = CoroutineScope(Job() + Dispatchers.IO)
        try {
            scope.launch {
                val res = assetService.assetService.getAllAssets().data

                when(_sortBy) {
                    SortBy.Rank -> _response.value = res.sortedByDescending { it.rank }
                    SortBy.MarketCap -> _response.value = res.sortedByDescending { it.marketCapUsd }
                    SortBy.Price -> _response.value = res.sortedByDescending { it.priceUsd }
                }
            }
        } catch (err: Error) {
            println(err)
        }
    }
    fun setSort(sortBy: SortBy) {
        _sortBy = sortBy
        loadData()
    }
}