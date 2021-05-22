package com.example.composeplayground.screens.home

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.ui.theme.PortfolioTheme

@Composable
fun HomeScreen(navController: NavController) {
    Text(text = "Home")
    Button(onClick = { navController.navigate("detail") }) {

    }
}

@Preview
@Composable
fun DefaultPreview() {
    PortfolioTheme {
        HomeScreen(rememberNavController())
    }
}

@Preview
@Composable
fun DefaultPreviewDark() {
    PortfolioTheme(true) {
        HomeScreen(rememberNavController())
    }
}