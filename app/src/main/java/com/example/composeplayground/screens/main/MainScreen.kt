package com.example.composeplayground.screens.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.screens.about.AboutScreen
import com.example.composeplayground.screens.detail.DetailScreen
import com.example.composeplayground.screens.home.HomeScreen
import com.example.composeplayground.widgets.InsetBottomNavigation
import com.example.composeplayground.widgets.bottomNavigationHeight

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        drawerElevation = 0.dp,
        bottomBar = { BottomBar(navController) }
    ) {

        NavHost(navController = navController, startDestination = BottomNavDestination.Home.route) {
            composable(BottomNavDestination.Home.route) { HomeScreen(navController) }
            composable(BottomNavDestination.About.route) { AboutScreen() }
            composable("detail") { DetailScreen(navController) }
        }
    }
}


@Composable
private fun BottomBar(navController: NavController) {
    val selectedTab = remember { mutableStateOf("home") }

    InsetBottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        BottomNavDestination.destinations.forEach {
            BottomNavigationItem(
                modifier = Modifier.bottomNavigationHeight(),
                selected = selectedTab.value == it.route,
                icon = { Icon(it.icon, it.route) },
                label = { Text(stringResource(id = it.titleResId)) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = LocalContentColor.current.copy(ContentAlpha.medium),
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.startDestinationRoute!!) {
                            
                        }
                        launchSingleTop = true
                    }
                    selectedTab.value = it.route
                })
        }
    }
}