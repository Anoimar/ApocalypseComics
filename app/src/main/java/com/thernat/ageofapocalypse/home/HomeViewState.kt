package com.thernat.ageofapocalypse.home

import com.thernat.ageofapocalypse.model.Comic

data class HomeViewState(
    val loading: Boolean = false,
    val comics: List<Comic> = emptyList(),
    val error: Boolean = false,
)
