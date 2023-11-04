package com.example.cryptohack.ui.theme.data

import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class CoinCapApiClient {
    val urlString2 = "https://api.coincap.io/v2/assets/bitcoin"

}

//    fun getBitcoinInfo() {
//        print("*********************************************************************************")
//        //val response = get(apiUrl)
//        val response: Response = apiUrl.httpGet()
//        val bitcoinData = JSONObject(response.toString())
//        val bitcoinName = bitcoinData.getJSONObject("data").getString("name")
//        val bitcoinPrice = bitcoinData.getJSONObject("data").getDouble("priceUsd")
//        print("*********************************************************************************")
//        println("Name: $bitcoinName")
//        println("Price (USD): $bitcoinPrice")
//
////        if (response.status() == 200) {
////            val bitcoinData = JSONObject(response.text)
////            val bitcoinName = bitcoinData.getJSONObject("data").getString("name")
////            val bitcoinPrice = bitcoinData.getJSONObject("data").getDouble("priceUsd")
////            println("Name: $bitcoinName")
////            println("Price (USD): $bitcoinPrice")
////        } else {
////            println("Failed to retrieve Bitcoin data. Status code: ${response.statusCode}")
////        }
//    }
//}
