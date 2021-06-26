package com.thernat.ageofapocalypse.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
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
fun HomeScreenScaffold(
    state: HomeViewState
) {
    Scaffold { paddingValues ->
        if(state.loading) {
            HomeScreenLoader()
        } else {
            HomeScreenContent(state)
        }
    }
}

@Composable
fun HomeScreenContent(state: HomeViewState) {
    Text(text = "Hello ${state.comics.first().name}!")
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