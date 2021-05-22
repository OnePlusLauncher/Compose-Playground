package com.example.composeplayground.screens.detail

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController) {
    Button(onClick = { navController.popBackStack() }) {
        Text(text = "Go Back")
    }
    Button(onClick = { navController.navigate("detail") }) {
        Text(text = "Go Next")
    }
}