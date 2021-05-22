package com.example.composeplayground.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
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
import com.example.composeplayground.extensions.then
import com.example.composeplayground.ui.theme.PortfolioTheme
import com.google.accompanist.insets.navigationBarsHeight

private val BottomNavigationBarHeight = 56.dp

@Composable
fun InsetBottomNavigation(
    modifier: Modifier = Modifier,
    elevation: Dp = BottomNavigationDefaults.Elevation,
    applyWindowInsets: Boolean = true,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        elevation = elevation,
        modifier = applyWindowInsets then modifier.navigationBarsHeight(BottomNavigationBarHeight)
            ?: modifier.height(BottomNavigationBarHeight),
    ) {
        BottomNavigation(
            elevation = 0.dp,
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            content = content
        )
    }
}

fun Modifier.bottomNavigationHeight() = height(BottomNavigationBarHeight)

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
    PortfolioTheme(false) {
        InsetBottomNavigation(content = previewRowScope)
    }
}

@Preview
@Composable
private fun PreviewDark() {
    PortfolioTheme(true) {
        InsetBottomNavigation(content = previewRowScope)
    }
}
