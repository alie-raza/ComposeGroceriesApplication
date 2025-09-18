package com.alidev.binancepricetracking.tickers

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable

@ExperimentalAnimationApi
@Composable
fun EnterTransition(
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(
        visible = true, // or some state variable
        enter = slideInHorizontally(initialOffsetX = { it }),
        exit = slideOutHorizontally(targetOffsetX = { -it })
    ) {
        content()
    }
}
