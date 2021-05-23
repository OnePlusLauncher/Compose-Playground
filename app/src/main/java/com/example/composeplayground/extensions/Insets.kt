package com.example.composeplayground.extensions

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.toPaddingValues

fun Modifier.horizontalInsets(): Modifier = composed {
    padding(LocalWindowInsets.current.systemBars.toPaddingValues(top = false, bottom = false))
}
