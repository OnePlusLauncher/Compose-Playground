package com.example.composeplayground.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.composeplayground.screens.about.AboutScreen
import com.example.composeplayground.screens.navigation.NavigationScreen
import com.example.composeplayground.screens.rickmorty.RickMortyScreen
import com.example.composeplayground.screens.rickmorty.RickMortyViewModel
import com.example.composeplayground.screens.rickmorty.data.RickMortyRepository
import com.example.composeplayground.screens.rootnavigation.RootNavigationScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavDestination.Navigation.route,
        modifier = modifier
    ) {
        composable(BottomNavDestination.Navigation.route) { RootNavigationScreen(navController) }
        composable(BottomNavDestination.RickMorty.route) {
            RickMortyScreen(navController, RickMortyViewModel(RickMortyRepository()))
        }
        composable(BottomNavDestination.About.route) { AboutScreen() }
        composable(
            "nested_navigation/{count}",
            arguments = listOf(navArgument("count") { type = NavType.IntType })
        ) { NavigationScreen(navController, it.arguments!!.getInt("count")) }
    }
}
