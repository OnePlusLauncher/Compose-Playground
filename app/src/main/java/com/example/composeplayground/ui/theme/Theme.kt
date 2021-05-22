package com.example.composeplayground.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private val DarkColorPalette = darkColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryColorVariant,
    secondary = PrimaryColorVariant,
    onPrimary = Color.White,
    onSecondary = Color.White
)

private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryColorVariant,
    secondary = PrimaryColor
)

@Composable
fun PlaygroundTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

enum class AppTheme {
    LIGHT, DARK, SYSTEM;

    companion object {
        private const val themePreferenceKey = "ThemeMode"

        private fun withValue(value: String?) =
            values().firstOrNull { it.name == value } ?: default()

        private fun default() = SYSTEM

        fun currentTheme(dataStore: DataStore<Preferences>): AppTheme = runBlocking {
            val savedTheme = dataStore.data.first()[stringPreferencesKey(themePreferenceKey)]
            withValue(savedTheme)
        }

        suspend fun updateTheme(dataStore: DataStore<Preferences>, appTheme: AppTheme) {
            dataStore.edit {
                it[stringPreferencesKey(themePreferenceKey)] = appTheme.name
            }
        }

        @Composable
        fun themeChanges(dataStore: DataStore<Preferences>) = dataStore.data
            .map { it[stringPreferencesKey(themePreferenceKey)] }
            .map(::withValue)
            .distinctUntilChanged()
            .collectAsState(initial = currentTheme(dataStore), context = Dispatchers.Default)
    }
}

fun AppTheme.isDarkTheme(systemDarkTheme: Boolean) = when (this) {
    AppTheme.LIGHT -> false
    AppTheme.DARK -> true
    AppTheme.SYSTEM -> systemDarkTheme
}

