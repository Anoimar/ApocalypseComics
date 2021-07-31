package com.thernat.ageofapocalypse.model

data class Comic(
    val id: Int,
    val name: String,
    val imageUrl: String?,
) {
    companion object ComicFactory {
        fun create(result: Result) =
            Comic(
                id = result.id,
                name = result.title,
                imageUrl = result.thumbnail?.let {
                    val baseUrl = it.path?.replace("http","https")//From some reason marvel api returns http url
                    "${baseUrl}.${it.extension}"
                }
            )
    }
}

