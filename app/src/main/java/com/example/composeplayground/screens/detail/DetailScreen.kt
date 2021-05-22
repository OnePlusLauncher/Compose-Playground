package com.example.composeplayground.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun DetailScreen(navController: NavController, count: Int) {
    Scaffold(modifier = Modifier.statusBarsPadding()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = {
                    navController.navigate("detail/${count + 1}")
                }
            ) {
                Text("Navigate infinitely ($count)")
            }

            Text(text = "Try changing tabs", Modifier.padding(top = 16.dp))

            Button(
                onClick = {
                    navController.popBackStack("home", false)
                },
                modifier = Modifier.padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.error
                )
            ) {
                Text(text = "Go to root")
            }
        }
    }
}