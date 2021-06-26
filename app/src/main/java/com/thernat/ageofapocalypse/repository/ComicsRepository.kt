package com.thernat.ageofapocalypse.repository

import com.thernat.ageofapocalypse.api.MarvelService
import com.thernat.ageofapocalypse.model.Comic
import com.thernat.ageofapocalypse.ui.mockEvents
import kotlinx.coroutines.delay

class ComicsRepository(private val marvelService: MarvelService) {

    suspend fun getComics(): List<Comic> {
        val response = marvelService.getComics()
        return response.data?.results?.let { it ->
            it.map { result ->
                Comic(result.title)
            }
        } ?: listOf()
    }
}