package com.example.composeplayground.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.ui.theme.PlaygroundTheme
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(modifier = Modifier.statusBarsPadding()) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Button(onClick = { navController.navigate("detail/1") }) {
                Text("Navigate")
            }
        }
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