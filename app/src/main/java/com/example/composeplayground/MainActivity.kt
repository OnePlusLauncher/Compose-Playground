package com.example.composeplayground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposePlaygroundTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hello $name!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                Button(
                    onClick = {

                    },
                ) {
                    Text("Click me!")
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun DefaultPreviewDark() {
    ComposePlaygroundTheme(true) {
        Greeting("Android")
    }
}