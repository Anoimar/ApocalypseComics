package com.thernat.ageofapocalypse.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thernat.ageofapocalypse.repository.ComicsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val comicsRepository: ComicsRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState: StateFlow<HomeViewState> = _viewState

    init {
        fetchEvents()
    }

    private fun fetchEvents() {
        _viewState.value = _viewState.value.copy(
            loading = true
        )
        viewModelScope.launch {
            val events = comicsRepository.getComics()
            _viewState.value = _viewState.value.copy(
                comics = events,
                loading = false,
            )
        }
    }
}