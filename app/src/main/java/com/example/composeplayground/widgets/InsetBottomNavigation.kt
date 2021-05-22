package com.example.composeplayground.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.PlaygroundTheme
import com.google.accompanist.insets.navigationBarsHeight

@Composable
fun InsetBottomNavigation(
    modifier: Modifier = Modifier,
    elevation: Dp = BottomNavigationDefaults.Elevation,
    applyWindowInsets: Boolean = true,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable RowScope.() -> Unit
) {
    Surface(elevation = elevation) {
        Column {
            BottomNavigation(
                elevation = 0.dp,
                backgroundColor = backgroundColor,
                contentColor = contentColor,
                content = content
            )
            if (applyWindowInsets) Spacer(modifier = modifier.navigationBarsHeight())
        }
    }
}

private val previewRowScope: @Composable RowScope.() -> Unit = {
    BottomNavigationItem(
        selected = true,
        selectedContentColor = MaterialTheme.colors.primary,
        unselectedContentColor = LocalContentColor.current.copy(ContentAlpha.medium),
        icon = { Icon(Icons.Outlined.Home, "Home") },
        onClick = { })

    BottomNavigationItem(
        selected = false,
        selectedContentColor = MaterialTheme.colors.primary,
        unselectedContentColor = LocalContentColor.current.copy(ContentAlpha.medium),
        icon = { Icon(Icons.Outlined.Info, "About") },
        onClick = { })

    BottomNavigationItem(
        selected = false,
        selectedContentColor = MaterialTheme.colors.primary,
        unselectedContentColor = LocalContentColor.current.copy(ContentAlpha.medium),
        icon = { Icon(Icons.Outlined.MailOutline, "Main") },
        onClick = { })
}

@Preview
@Composable
private fun PreviewLight() {
    PlaygroundTheme(false) {
        InsetBottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
            content = previewRowScope
        )
    }
}

@Preview
@Composable
private fun PreviewDark() {
    PlaygroundTheme(true) {
        InsetBottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
            content = previewRowScope
        )
    }
}
