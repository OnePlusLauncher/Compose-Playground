package com.example.composeplayground.screens.about

import android.util.Log
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
import com.example.composeplayground.extensions.then
import com.example.composeplayground.ui.theme.AppTheme
import com.example.composeplayground.widgets.InsetTopAppBar
import com.google.accompanist.insets.statusBarsHeight
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.Moon
import compose.icons.evaicons.outline.Settings
import compose.icons.evaicons.outline.Sun
import kotlinx.coroutines.launch

@Composable
fun AboutScreen() {
    val context = LocalContext.current
    val selectedTheme = AppTheme.themeChanges(context.dataStore).value

    Scaffold(
        topBar = { AboutTopBar() }
    ) {
        LazyColumn {
            item { ToggleThemeItem(selectedTheme) }
        }
    }
}

@Composable
private fun ToggleThemeItem(selectedTheme: AppTheme) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {

        Log.d("Main", "$selectedTheme")

        Text("Select Theme", Modifier.weight(1f))
        ThemeIcon(
            EvaIcons.Outline.Sun,
            "Light",
            AppTheme.LIGHT,
            selectedTheme == AppTheme.LIGHT
        )
        ThemeIcon(
            EvaIcons.Outline.Moon,
            "Dark",
            AppTheme.DARK,
            selectedTheme == AppTheme.DARK
        )
        ThemeIcon(
            EvaIcons.Outline.Settings,
            "Auto",
            AppTheme.SYSTEM,
            selectedTheme == AppTheme.SYSTEM
        )
    }
}

@Composable
private fun ThemeIcon(
    imageVector: ImageVector,
    contentDescription: String,
    appTheme: AppTheme,
    isSelected: Boolean
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    IconButton(onClick = {
        scope.launch {
            AppTheme.updateTheme(context.dataStore, appTheme)
        }
    }) {
        Icon(
            imageVector,
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

