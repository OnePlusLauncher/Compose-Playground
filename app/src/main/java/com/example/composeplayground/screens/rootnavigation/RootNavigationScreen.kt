package com.example.composeplayground.screens.rootnavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.example.composeplayground.R
import com.example.composeplayground.ui.theme.PlaygroundTheme
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun RootNavigationScreen(navController: NavController) {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.navigation_animation) }

    Scaffold(modifier = Modifier.statusBarsPadding()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            LottieAnimation(
                animationState = rememberLottieAnimationState(repeatCount = Integer.MAX_VALUE),
                spec = animationSpec,
                modifier = Modifier.widthIn(max = 300.dp)
            )

            Button(
                modifier = Modifier.padding(top = 16.dp, bottom = 140.dp),
                onClick = {
                    navController.navigate("nested_navigation/1")
                }
            ) {
                Text("Navigate")
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    PlaygroundTheme {
        RootNavigationScreen(rememberNavController())
    }
}

@Preview
@Composable
fun DefaultPreviewDark() {
    PlaygroundTheme(true) {
        RootNavigationScreen(rememberNavController())
    }
}