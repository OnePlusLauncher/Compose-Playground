package com.example.composeplayground

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.composeplayground.extensions.dataStore
import com.example.composeplayground.screens.main.MainScreen
import com.example.composeplayground.ui.theme.AppTheme
import com.example.composeplayground.ui.theme.PlaygroundTheme
import com.example.composeplayground.ui.theme.isDarkTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        setContent {
            val appTheme = AppTheme.themeChanges(dataStore)
            val darkTheme = appTheme.value.isDarkTheme()

            toggleSystemBars(darkTheme)

            PlaygroundTheme(darkTheme = darkTheme) {
                ProvideWindowInsets {
                    MainScreen()
                }
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun toggleSystemBars(darkTheme: Boolean) {
        var flags = window.decorView.systemUiVisibility

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!darkTheme) {
                if (flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR == 0) {
                    flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            } else {
                if (flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR != 0) {
                    flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            flags = if (darkTheme) {
                flags and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
            } else {
                flags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
        window.decorView.systemUiVisibility = flags
    }
}
