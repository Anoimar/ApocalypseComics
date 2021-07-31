package com.thernat.ageofapocalypse.detail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.thernat.ageofapocalypse.components.ComicDetailsCard

const val detailScreenId = "detail"

@Composable
fun ComicDetailsScreen(id: Int?) {
    val viewModel: ComicDetailsViewModel = hiltViewModel()
    val currentState: State<ComicDetailsScreenState> = viewModel.viewState.collectAsState()
    id?.let {
        viewModel.setComicId(id)
    }
    ComicDetailsScreenScaffold(state = currentState.value)
}


@Composable
fun ComicDetailsScreenScaffold(
    state: ComicDetailsScreenState
){
    Scaffold(
        backgroundColor = MaterialTheme.colors.background
    ) {
        state.comic?.let {
            ComicDetailsCard(
                imageUrl = it.imageUrl,
                name = it.name
            )
        }
    }
}