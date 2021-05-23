package com.example.composeplayground.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.extensions.then
import com.example.composeplayground.widgets.InsetBottomNavigation
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) {
        Column(Modifier.navigationBarsPadding(left = false, right = false)) {
            AppNavigation(
                navController = navController,
                // Compensate the padding from the bottom bar insets
                modifier = Modifier.padding(bottom = 56.dp)
            )
        }
    }
}

@Composable
private fun BottomBar(navController: NavController) {
    val selectedTab = rememberSaveable { mutableStateOf("navigation") }

    InsetBottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        BottomNavDestination.destinations.forEach {
            val isSelected = selectedTab.value == it.route
            BottomNavigationItem(
                selected = isSelected,
                icon = { Icon(isSelected then it.selectedIcon ?: it.icon, it.route) },
                label = { Text(stringResource(id = it.titleResId)) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = LocalContentColor.current.copy(ContentAlpha.medium),
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.startDestinationRoute!!) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                    selectedTab.value = it.route
                })
        }
    }
}
