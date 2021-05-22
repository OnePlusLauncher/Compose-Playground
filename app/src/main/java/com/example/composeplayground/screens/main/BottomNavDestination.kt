package com.example.composeplayground.screens.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composeplayground.R

sealed class BottomNavDestination(
    val route: String,
    @StringRes val titleResId: Int,
    val icon: ImageVector
) {
    companion object {
        val destinations = listOf(Home, About)
    }

    object Home : BottomNavDestination(
        route = "home",
        titleResId = R.string.home,
        icon = Icons.Outlined.Home
    )

    object About : BottomNavDestination(
        route = "about",
        titleResId = R.string.about,
        icon = Icons.Outlined.Info
    )
}