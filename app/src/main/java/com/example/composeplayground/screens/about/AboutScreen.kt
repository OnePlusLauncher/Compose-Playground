package com.example.composeplayground.screens.about

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.composeplayground.extensions.dataStore
import com.example.composeplayground.extensions.horizontalInsets
import com.example.composeplayground.extensions.then
import com.example.composeplayground.ui.theme.AppTheme
import com.example.composeplayground.widgets.InsetTopAppBar
import com.google.accompanist.insets.statusBarsHeight
import compose.icons.EvaIcons
import compose.icons.evaicons.Fill
import compose.icons.evaicons.Outline
import compose.icons.evaicons.fill.Moon
import compose.icons.evaicons.fill.Settings
import compose.icons.evaicons.fill.Sun
import compose.icons.evaicons.outline.Moon
import compose.icons.evaicons.outline.Settings
import compose.icons.evaicons.outline.Sun
import kotlinx.coroutines.launch

@Composable
fun AboutScreen() {
    Scaffold(
        topBar = { AboutTopBar() }
    ) {
        LazyColumn(Modifier.horizontalInsets()) {
            item { ToggleThemeItem() }
        }
    }
}

@Composable
private fun ToggleThemeItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Select Theme", Modifier.weight(1f))

        ThemeIcon(
            EvaIcons.Outline.Sun,
            EvaIcons.Fill.Sun,
            "Light",
            AppTheme.LIGHT
        )
        ThemeIcon(
            EvaIcons.Outline.Moon,
            EvaIcons.Fill.Moon,
            "Dark",
            AppTheme.DARK
        )
        ThemeIcon(
            EvaIcons.Outline.Settings,
            EvaIcons.Fill.Settings,
            "Auto",
            AppTheme.SYSTEM
        )
    }
}

@Composable
private fun ThemeIcon(
    icon: ImageVector,
    selectedIcon: ImageVector,
    contentDescription: String,
    appTheme: AppTheme
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val selectedTheme = AppTheme.themeChanges(context.dataStore).value
    val isSelected = selectedTheme == appTheme

    IconButton(onClick = {
        scope.launch {
            AppTheme.updateTheme(context.dataStore, appTheme)
        }
    }) {
        Icon(
            isSelected then selectedIcon ?: icon,
            contentDescription,
            tint = isSelected then MaterialTheme.colors.primary
                ?: LocalContentColor.current.copy(
                    alpha = LocalContentAlpha.current
                )
        )
    }
}

@Composable
private fun AboutTopBar() {
    InsetTopAppBar(
        modifier = Modifier.statusBarsHeight(56.dp),
        backgroundColor = MaterialTheme.colors.background,
        title = { Text("About") }
    )
}
