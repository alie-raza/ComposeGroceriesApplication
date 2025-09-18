package com.alidev.binancepricetracking.respositories

import com.alidev.binancepricetracking.models.RawData
import com.alidev.binancepricetracking.models.Ticker
import com.alidev.binancepricetracking.services.IWebSocketChannel
import com.alidev.binancepricetracking.services.RetrofitBuilder
import com.alidev.binancepricetracking.services.WebSocketChannel
import com.alidev.binancepricetracking.utils.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class TickerRepository {
    private lateinit var channel: IWebSocketChannel
    private val apiService = RetrofitBuilder.apiService

    private val gson = Gson()
    private val tickerType = object : TypeToken<List<Ticker>>() {}.type

    private fun rawDataToListTickers(rawData: RawData): List<Ticker> {
        return gson.fromJson(
            rawData.json,
            tickerType
        )
    }

    fun createTickerStream(scope: CoroutineScope): Flow<List<Ticker>?> {
        channel = WebSocketChannel(scope, Constants.WS_TICKER_URL)
//        return flow { emit(channel.getIncoming().first().let { rawDataToListTickers(it) }) }
        return channel.getIncoming().map { rawDataToListTickers(it) }
    }

    fun webSocketSend(data: RawData) {
        channel.send(data)
    }

    suspend fun getTickers(): List<Ticker> {
        return withContext(Dispatchers.IO) {
            apiService.getTickers().execute().body() ?: listOf()
        }
    }
}