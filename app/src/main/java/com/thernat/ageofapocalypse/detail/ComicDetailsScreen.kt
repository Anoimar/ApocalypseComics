package com.thernat.ageofapocalypse.detail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

const val detailScreenId = "detail"

@Composable
fun ComicDetailsScreen(
    comicId: String?
) {
    val viewModel: ComicDetailsViewModel = hiltViewModel()
    val currentState: State<ComicDetailsScreenState> = viewModel.viewState.collectAsState()
    ComicDetailsScreenScaffold(state = currentState.value)
}

@Composable
fun ComicDetailsScreenScaffold(
    state: ComicDetailsScreenState
){
    Scaffold(
        backgroundColor = MaterialTheme.colors.background
    ) {

    }

}