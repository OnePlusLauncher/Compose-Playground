package com.example.composeplayground.screens.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.composeplayground.screens.about.AboutScreen
import com.example.composeplayground.screens.detail.DetailScreen
import com.example.composeplayground.screens.home.HomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavDestination.Home.route) {
        composable(BottomNavDestination.Home.route) { HomeScreen(navController) }
        composable(BottomNavDestination.About.route) { AboutScreen() }
        composable(
            "detail/{count}",
            arguments = listOf(navArgument("count") { type = NavType.IntType })
        ) { DetailScreen(navController, it.arguments!!.getInt("count")) }
    }
}