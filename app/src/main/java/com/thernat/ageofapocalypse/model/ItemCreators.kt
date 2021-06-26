package com.thernat.ageofapocalypse.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemCreators(
    @Json(name = "name")
    val name: String?,
    @Json(name = "resourceURI")
    val resourceURI: String?,
    @Json(name = "role")
    val role: String?
)