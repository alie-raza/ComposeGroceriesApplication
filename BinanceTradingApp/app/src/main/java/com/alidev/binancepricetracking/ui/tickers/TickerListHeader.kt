package com.alidev.binancepricetracking.ui.tickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alidev.binancepricetracking.noRippleClickable
import com.alidev.binancepricetracking.viewmodels.TickersViewModel

@Composable
fun TickerListHeader(tickersViewModel: TickersViewModel) {
    Row(
        Modifier
            .height(25.dp)
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            Modifier.weight(1f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Modifier.noRippleClickable(){
                tickersViewModel.updateSortKey(SortParams.Pair)
            }


        }
    }
}