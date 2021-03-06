package com.thernat.ageofapocalypse.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.thernat.ageofapocalypse.R
import com.thernat.ageofapocalypse.components.ComicDetailsCard
import com.thernat.ageofapocalypse.components.ComicDetailsPerson
import com.thernat.ageofapocalypse.ui.theme.TextBackgroundColor
import com.thernat.ageofapocalypse.ui.theme.TextGrey

const val detailScreenId = "detail"

@ExperimentalFoundationApi
@Composable
fun ComicDetailsScreen(id: Int?,navController: NavController?) {
    val viewModel: ComicDetailsViewModel = hiltViewModel()
    val currentState: State<ComicDetailsScreenState> = viewModel.viewState.collectAsState()
    id?.let {
        viewModel.setComicId(id)
    }
    ComicDetailsScreenScaffold(state = currentState.value, navController)
}


@ExperimentalFoundationApi
@Composable
fun ComicDetailsScreenScaffold(
    state: ComicDetailsScreenState,
    navController: NavController?
){
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            TopAppBar(
                title = {

                },
                backgroundColor = MaterialTheme.colors.background,
                navigationIcon = {
                    IconButton(onClick = { navController?.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = Color.White,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        }
    ) {
        state.comic?.let {
            Box {
                Column(Modifier.fillMaxSize()) {
                    Image(
                        painterResource(id = R.drawable.family),
                        contentDescription = "Background",
                        modifier = Modifier
                            .weight(2f)
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillBounds,
                        alpha = 0.4F
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(3f)
                            .fillMaxWidth()
                            .background(TextBackgroundColor)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ComicDetailsCard(
                        imageUrl = it.imageUrl,
                        name = it.name
                    )
                    //Title
                    Text(
                        modifier = Modifier
                            .wrapContentSize(),
                        text = it.name,
                        color = MaterialTheme.colors.onPrimary,
                        style = TextStyle(
                            fontSize = 21.sp
                        )
                    )
                    //Creators
                    LazyVerticalGrid(
                        cells = GridCells.Fixed(2),
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            bottom = 4.dp
                        )
                    ) {
                        val creatorsList = it.creators.orEmpty()
                        items(creatorsList ) { creator ->
                            ComicDetailsPerson(
                                position = creator.role, personName = creator.name
                            )
                        }
                    }
                }
            }
        }
    }
}