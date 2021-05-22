package com.example.composeplayground.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeplayground.extensions.then
import com.example.composeplayground.ui.theme.PortfolioTheme
import com.google.accompanist.insets.statusBarsHeight

private val TopAppBarHeight = 56.dp

@Composable
fun InsetTopAppBar(
    modifier: Modifier = Modifier,
    elevation: Dp = BottomNavigationDefaults.Elevation,
    applyWindowInsets: Boolean = true,
    title: @Composable () -> Unit = {},
    navigationIcon: @Composable (() -> Unit)? = null,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    actions: @Composable RowScope.() -> Unit,
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

private val previewRowScope: @Composable RowScope.() -> Unit = {
    IconButton(onClick = { }) {
        Icon(Icons.Outlined.Info, contentDescription = "Call")
    }
    IconButton(onClick = { }) {
        Icon(Icons.Outlined.Share, contentDescription = "Call")
    }
}

@Preview
@Composable
private fun PreviewLight() {
    PortfolioTheme(false) {
        InsetTopAppBar(
            title = { Text("Preview Light") },
            backgroundColor = MaterialTheme.colors.background,
            actions = previewRowScope
        )
    }
}

@Preview
@Composable
private fun PreviewDark() {
    PortfolioTheme(true) {
        InsetTopAppBar(
            title = { Text("Preview Dark") },
            backgroundColor = MaterialTheme.colors.background,
            actions = previewRowScope
        )
    }
}