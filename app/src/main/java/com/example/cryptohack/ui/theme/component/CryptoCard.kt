package com.example.cryptohack.ui.theme.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CryptoCard(name: String, preis: Double, kuerzel: String) {

    Box(
        modifier = Modifier.fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .padding(top = 20.dp)
    ) {
        Column {
            Row {
                Text(
                    text = name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(120.dp))
                Text(
                    text = preis.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Text(
                text = kuerzel,
                fontSize = 15.sp,
            )
        }


    }


}