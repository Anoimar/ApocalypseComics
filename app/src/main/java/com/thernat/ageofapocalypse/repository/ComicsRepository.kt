package com.thernat.ageofapocalypse.repository

import com.thernat.ageofapocalypse.api.MarvelService
import com.thernat.ageofapocalypse.model.Comic

class ComicsRepository(private val marvelService: MarvelService) {

    private lateinit var comics: List<Comic>

    suspend fun getComics(): List<Comic> {
        val response = marvelService.getComics()
        return (response.data?.results?.let { it ->
            it.map { result ->
                Comic.create(result)
            }
        } ?: listOf()).also {
            comics = it
        }
    }

    fun getComic(id: Int) = comics.first {
        it.id == id
    }
}