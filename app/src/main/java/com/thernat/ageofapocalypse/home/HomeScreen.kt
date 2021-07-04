package com.thernat.ageofapocalypse.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.thernat.ageofapocalypse.components.BigComicCard
import com.thernat.ageofapocalypse.ui.mockEvents
import com.thernat.ageofapocalypse.ui.theme.AgeOfApocalypseTheme

const val homeScreenId = "home"

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val currentState: State<HomeViewState> = homeViewModel.viewState.collectAsState()

    HomeScreenScaffold(state = currentState.value)
}

@Composable
private fun HomeScreenLoader() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun HomeScreenError() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center),
            text = "Try again later :(",
            color = MaterialTheme.colors.onPrimary,
        )
    }
}


@Composable
fun HomeScreenScaffold(
    state: HomeViewState
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Apocalypse Tracking",
                    color = MaterialTheme.colors.onPrimary)
                },
                backgroundColor = MaterialTheme.colors.background
            )
        }
    ) {
        when {
            state.loading -> {
                HomeScreenLoader()
            }
            state.error -> {
                HomeScreenError()
            }
            else -> {
                HomeScreenContent(state)
            }
        }
    }
}

@Composable
fun HomeScreenContent(state: HomeViewState) {
    LazyRow() {
        items(state.comics) { comic ->
            BigComicCard(
                name = comic.name,
                imageUrl = comic.imageUrl
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    val previewState = HomeViewState(
        comics = mockEvents
    )
    AgeOfApocalypseTheme() {
        HomeScreenScaffold(state = previewState)
        
    }
}