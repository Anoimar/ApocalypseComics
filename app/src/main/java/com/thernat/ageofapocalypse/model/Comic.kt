package com.thernat.ageofapocalypse.model

data class Comic(
    val name: String,
    val imageUrl: String?,
) {
    companion object ComicFactory {
        fun create(result: Result) =
            Comic(
                name = result.title,
                imageUrl = result.thumbnail?.let {
                    val baseUrl = it.path?.replace("http","https")//From some reason marvel api returns http url
                    "${baseUrl}.${it.extension}"
                }
            )
    }
}

