package com.example.composeplayground.widgets

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeplayground.extensions.then
import com.example.composeplayground.ui.theme.PlaygroundTheme
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.insets.toPaddingValues

@Composable
fun InsetTopAppBar(
    modifier: Modifier = Modifier,
    elevation: Dp = BottomNavigationDefaults.Elevation,
    applyWindowInsets: Boolean = true,
    title: @Composable () -> Unit = {},
    navigationIcon: @Composable (() -> Unit)? = null,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    actions: @Composable RowScope.() -> Unit = {},
    scrollPosition: Int? = null,
) {

    val animatedElevation = animateDpAsState(
        if (scrollPosition != null) {
            (scrollPosition > 0) then elevation ?: 0.dp
        } else {
            elevation
        }
    )

    Surface(
        elevation = animatedElevation.value,
        modifier = modifier
    ) {
        Column(
            modifier = applyWindowInsets then Modifier.padding(
                LocalWindowInsets.current.systemBars.toPaddingValues(
                    top = false,
                    bottom = false
                )
            ) ?: Modifier
        ) {
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
    PlaygroundTheme(false) {
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
    PlaygroundTheme(true) {
        InsetTopAppBar(
            title = { Text("Preview Dark") },
            backgroundColor = MaterialTheme.colors.background,
            actions = previewRowScope
        )
    }
}
