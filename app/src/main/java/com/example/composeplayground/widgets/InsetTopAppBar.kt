package com.example.composeplayground.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeplayground.extensions.then
import com.google.accompanist.insets.statusBarsHeight

private val TopAppBarHeight = 56.dp

@Composable
fun InsetTopAppBar(
    modifier: Modifier = Modifier,
    elevation: Dp = BottomNavigationDefaults.Elevation,
    applyWindowInsets: Boolean = true,
    title: @Composable () -> Unit = {},
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
) {
    Surface(
        modifier = applyWindowInsets then modifier.statusBarsHeight(TopAppBarHeight)
            ?: modifier.height(TopAppBarHeight),
        elevation = elevation
    ) {
        Column {
            if (applyWindowInsets) Spacer(modifier = Modifier.statusBarsHeight())
            TopAppBar(
                title = title,
                navigationIcon = navigationIcon,
                backgroundColor = backgroundColor,
                contentColor = contentColor,
                elevation = 0.dp,
                actions = actions
            )
        }
    }
}