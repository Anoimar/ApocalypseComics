package com.thernat.ageofapocalypse.repository

import com.thernat.ageofapocalypse.api.MarvelService
import com.thernat.ageofapocalypse.model.Comic

class ComicsRepository(private val marvelService: MarvelService) {

    suspend fun getComics(): List<Comic> {
        val response = marvelService.getComics()
        return response.data?.results?.let { it ->
            it.map { result ->
                Comic.create(result)
            }
        } ?: listOf()
    }
}