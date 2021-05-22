package com.example.composeplayground.screens.home

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.ui.theme.PlaygroundTheme

@Composable
fun HomeScreen(navController: NavController) {
    Text(text = "Home")
    Button(onClick = { navController.navigate("detail") }) {

    }
}

@Preview
@Composable
fun DefaultPreview() {
    PlaygroundTheme {
        HomeScreen(rememberNavController())
    }
}

@Preview
@Composable
fun DefaultPreviewDark() {
    PlaygroundTheme(true) {
        HomeScreen(rememberNavController())
    }
}