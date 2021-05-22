package com.example.composeplayground.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.extensions.dataStore
import com.example.composeplayground.screens.about.AboutScreen
import com.example.composeplayground.screens.detail.DetailScreen
import com.example.composeplayground.screens.home.HomeScreen
import com.example.composeplayground.widgets.InsetBottomNavigation
import com.example.composeplayground.widgets.InsetTopAppBar
import com.example.composeplayground.widgets.bottomNavigationHeight
import com.google.accompanist.insets.statusBarsHeight
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            Column {
                InsetTopAppBar(
                    modifier = Modifier.statusBarsHeight(56.dp),
                    backgroundColor = MaterialTheme.colors.background,
                    title = { Text("Hello") },
                    actions = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    context.dataStore.edit {
                                        val key = booleanPreferencesKey("darkTheme")
                                        it[key] = !(it[key] ?: false)
                                    }
                                }
                            }) {
                            Icon(Icons.Filled.Settings, null)
                        }
                    })
            }
        },
        bottomBar = {
            InsetBottomNavigation(
                backgroundColor = MaterialTheme.colors.background
            ) {
                BottomNavDestination.destinations.forEach {
                    BottomNavigationItem(
                        modifier = Modifier.bottomNavigationHeight(),
                        selected = currentRoute == it.route,
                        icon = { Icon(it.icon, it.route) },
                        label = { Text(stringResource(id = it.titleResId)) },
                        selectedContentColor = MaterialTheme.colors.primary,
                        unselectedContentColor = LocalContentColor.current.copy(ContentAlpha.medium),
                        onClick = {
                            navController.navigate(it.route) {
                                popUpTo(navController.graph.startDestinationRoute!!) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        }
    ) {

        NavHost(navController = navController, startDestination = BottomNavDestination.Home.route) {
            composable(BottomNavDestination.Home.route) { HomeScreen(navController) }
            composable(BottomNavDestination.About.route) { AboutScreen(navController) }
            composable("detail") { DetailScreen(navController) }
        }
    }
}