package com.example.composeplayground.screens.main

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composeplayground.R
import compose.icons.EvaIcons
import compose.icons.evaicons.Fill
import compose.icons.evaicons.Outline
import compose.icons.evaicons.fill.Home
import compose.icons.evaicons.fill.Info
import compose.icons.evaicons.outline.Home
import compose.icons.evaicons.outline.Info

sealed class BottomNavDestination(
    val route: String,
    @StringRes val titleResId: Int,
    val icon: ImageVector,
    val selectedIcon: ImageVector
) {
    companion object {
        val destinations = listOf(Home, About)
    }

    object Home : BottomNavDestination(
        route = "home",
        titleResId = R.string.home,
        icon = EvaIcons.Outline.Home,
        selectedIcon = EvaIcons.Fill.Home
    )

    object About : BottomNavDestination(
        route = "about",
        titleResId = R.string.about,
        icon = EvaIcons.Outline.Info,
        selectedIcon = EvaIcons.Fill.Info
    )
}