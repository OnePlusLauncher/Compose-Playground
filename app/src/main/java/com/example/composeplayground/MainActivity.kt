package com.example.composeplayground

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.example.composeplayground.extensions.dataStore
import com.example.composeplayground.extensions.then
import com.example.composeplayground.screens.main.MainScreen
import com.example.composeplayground.ui.theme.PortfolioTheme
import com.google.accompanist.insets.ProvideWindowInsets
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        runBlocking {
            val darkTheme = dataStore.data.first()[booleanPreferencesKey("darkTheme")]
                ?: false
            AppCompatDelegate.setDefaultNightMode(darkTheme then MODE_NIGHT_YES ?: MODE_NIGHT_NO)
        }
        super.onCreate(savedInstanceState)

        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        dataStore.data
            .drop(1)
            .map {
                it[booleanPreferencesKey("darkTheme")] then MODE_NIGHT_YES
                    ?: MODE_NIGHT_NO
            }
            .distinctUntilChanged()
            .onEach(AppCompatDelegate::setDefaultNightMode)
            .launchIn(CoroutineScope(Dispatchers.Main.immediate))

        setContent {
            PortfolioTheme(darkTheme = AppCompatDelegate.getDefaultNightMode() == MODE_NIGHT_YES) {
                ProvideWindowInsets {
                    MainScreen()
                }
            }
        }
    }
}
