package com.alidev.binancepricetracking.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alidev.binancepricetracking.utils.Constants
import com.alidev.binancepricetracking.viewmodels.TickersViewModel

enum class Tabs(val symbol: String) {
    BTC(Constants.BTC), ETH(Constants.ETH), BNB(Constants.BNB), USDT(Constants.USDT),
}


@Composable
fun AppTabBar(tickersViewModel: TickersViewModel) {
    val currentTab: Tabs by tickersViewModel.currentTab.observeAsState(initial = Tabs.BTC)

    val interactionSource = remember { MutableInteractionSource() }

    Row(Modifier.background(color = MaterialTheme.colors.primaryVariant)) {
        Tabs.entries.forEach { tab ->
            Row(
                Modifier
                    .weight(1f)
                    .height(35.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {},
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        tab.name,
                        fontSize = 14.sp,
                        color = if (tab == currentTab) MaterialTheme.colors.primary else MaterialTheme.colors.onSecondary,
                        fontWeight = FontWeight.W600
                    )
                    Divider(
                        Modifier.padding(top = 2.dp),
                        color = if (tab == currentTab) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant,
                        thickness = 2.dp
                    )
                }

            }
        }
    }
}