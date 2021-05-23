@file:OptIn(ExperimentalAnimationApi::class)

package com.example.composeplayground.screens.rickmorty

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.example.composeplayground.R
import com.example.composeplayground.extensions.horizontalInsets
import com.example.composeplayground.screens.rickmorty.data.Character
import com.example.composeplayground.widgets.InsetTopAppBar
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun RickMortyScreen(
    navController: NavController,
    viewModel: RickMortyViewModel
) {
    val state = viewModel.state.collectAsState()
    Scaffold(
        topBar = {
            InsetTopAppBar(
                title = { Text(text = "Rick & Morty") },
                backgroundColor = MaterialTheme.colors.background
            )
        }
    ) {
        when (val currentState = state.value) {
            RickMortyState.Error -> Error(viewModel::retry)
            RickMortyState.Loading -> Loading()
            is RickMortyState.Success -> CharactersList(currentState.characters)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CharactersList(characters: List<Character>) {
    LazyVerticalGrid(
        GridCells.Adaptive(100.dp),
        Modifier
            .horizontalInsets()
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(characters) {
            Card {
                Image(painter = rememberCoilPainter(it.image, fadeIn = true), it.name)
            }
        }
    }
}

@Composable
private fun Error(onRetry: () -> Unit) {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.morty_error) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        AnimatedVisibility(true) {
            LottieAnimation(
                modifier = Modifier.width(200.dp),
                spec = animationSpec,
                animationState = rememberLottieAnimationState(repeatCount = Integer.MAX_VALUE)
            )
        }

        Button(onClick = onRetry, Modifier.padding(top = 16.dp)) {
            Text("Retry")
        }
    }
}

@Composable
private fun Loading() {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.morty_loading) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(true) {
            LottieAnimation(
                modifier = Modifier.width(200.dp),
                spec = animationSpec,
                animationState = rememberLottieAnimationState(repeatCount = Integer.MAX_VALUE)
            )
        }
    }
}