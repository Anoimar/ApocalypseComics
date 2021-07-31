package com.thernat.ageofapocalypse.detail

import androidx.lifecycle.ViewModel
import com.thernat.ageofapocalypse.repository.ComicsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ComicDetailsViewModel @Inject constructor(
    private val comicsRepository: ComicsRepository
) : ViewModel() {
    private val _viewState = MutableStateFlow(ComicDetailsScreenState(null))
    val viewState: StateFlow<ComicDetailsScreenState> = _viewState
}