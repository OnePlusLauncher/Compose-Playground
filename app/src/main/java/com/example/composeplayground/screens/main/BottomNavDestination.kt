package com.example.composeplayground.screens.main

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composeplayground.R
import compose.icons.EvaIcons
import compose.icons.evaicons.Fill
import compose.icons.evaicons.Outline
import compose.icons.evaicons.fill.Battery
import compose.icons.evaicons.fill.Info
import compose.icons.evaicons.fill.Navigation
import compose.icons.evaicons.outline.Battery
import compose.icons.evaicons.outline.Info
import compose.icons.evaicons.outline.Navigation

sealed class BottomNavDestination(
    val route: String,
    @StringRes val titleResId: Int,
    val icon: ImageVector,
    val selectedIcon: ImageVector
) {
    companion object {
        val destinations = listOf(Navigation, RickMorty, About)
    }

    object Navigation : BottomNavDestination(
        route = "navigation",
        titleResId = R.string.navigation,
        icon = EvaIcons.Outline.Navigation,
        selectedIcon = EvaIcons.Fill.Navigation
    )

    object RickMorty : BottomNavDestination(
        route = "rick-morty",
        titleResId = R.string.rick_morty,
        icon = EvaIcons.Outline.Battery,
        selectedIcon = EvaIcons.Fill.Battery
    )

    object About : BottomNavDestination(
        route = "about",
        titleResId = R.string.about,
        icon = EvaIcons.Outline.Info,
        selectedIcon = EvaIcons.Fill.Info
    )
}
