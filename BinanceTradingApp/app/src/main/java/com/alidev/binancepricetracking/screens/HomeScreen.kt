package com.alidev.binancepricetracking.screens

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.alidev.binancepricetracking.tickers.AppTabBar
import com.alidev.binancepricetracking.tickers.AppTopBar
import com.alidev.binancepricetracking.tickers.Tabs
import com.alidev.binancepricetracking.tickers.TickerListCompose
import com.alidev.binancepricetracking.tickers.TickerListHeader
import com.alidev.binancepricetracking.viewmodels.TickersViewModel

@SuppressLint("UnusedCrossfadeTargetStateParameter")
@Composable
fun MainScreenCompose(
	tickersViewModel: TickersViewModel,
	onNavigateOrderBook: (String, String) -> Unit
) {
	val currentTab: Tabs by tickersViewModel.currentTab.observeAsState(initial = Tabs.BTC)

	Scaffold(
		topBar = { AppTopBar() }
	) { paddingValues ->
		Column(modifier = Modifier.padding(paddingValues)) {
			AppTabBar(tickersViewModel)
			TickerListHeader(tickersViewModel)
			Crossfade(targetState = currentTab) {
				TickerListCompose(tickersViewModel, onNavigateOrderBook)
			}
		}
	}
}