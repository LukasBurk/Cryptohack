package com.example.cryptohack.view

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cryptohack.network.CryptoCurrency
import com.example.cryptohack.viewmodel.AssetsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptohack.viewmodel.SortBy
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeScreen(viewModel: AssetsViewModel = viewModel()) {
    val cryptos by viewModel.response.collectAsState()
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "CryptoHack",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 50.dp)
        )
        var showMenu by remember { mutableStateOf(false) }
        Box(modifier = Modifier.align(Alignment.End)){
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(Icons.Default.MoreVert, "")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }) {
                DropdownMenuItem(text = { Text("Rank") }, onClick = { viewModel.setSort(SortBy.Rank) })
                DropdownMenuItem(text = { Text("Price") }, onClick = { viewModel.setSort(SortBy.Price) })
                DropdownMenuItem(text = { Text("MarketCap") }, onClick = { viewModel.setSort(SortBy.MarketCap) })
            }
        }

        Button(onClick = { viewModel.loadData() }, content = { Text(text = "refresh")})

        LazyColumn {
            items(cryptos.size, key = { index -> cryptos[index].id }) {
                index ->
                CryptoRow(cryptos[index])
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun CryptoRow(cryptoCurrency: CryptoCurrency) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(0.9f)
    ) {
        Column {
            Text(text = cryptoCurrency.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            Text(text = cryptoCurrency.symbol, style = MaterialTheme.typography.titleSmall)
        }
        val format = NumberFormat.getCurrencyInstance(Locale.US);
        format.maximumFractionDigits = 4
        Text(format.format(cryptoCurrency.priceUsd), fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
    }
}