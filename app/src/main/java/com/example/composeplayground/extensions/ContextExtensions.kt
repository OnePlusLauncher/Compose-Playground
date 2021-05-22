package com.example.composeplayground.extensions

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "")

object ThemeState {
    var darkModeState: MutableState<Boolean> = mutableStateOf(false)
}