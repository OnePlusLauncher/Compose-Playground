package com.example.composeplayground.extensions

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "")

val Context.systemDarkTheme
    get() = resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == AppCompatDelegate.MODE_NIGHT_YES