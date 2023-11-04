package com.example.cryptohack.ui.theme.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptohack.ui.theme.component.CryptoCard
import com.example.cryptohack.ui.theme.component.DropDownMenu

@Composable
fun HomeScreen() {

    Column {
        Text(
            text = "Cryptofake",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            //textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .align(alignment = CenterHorizontally)
                .padding(top = 50.dp),


            )
        DropDownMenu()

        CryptoCard("Bitcoin", 20.00, "BTC")


    }

}