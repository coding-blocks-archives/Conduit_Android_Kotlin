package io.realworld.api.models.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Article(
    @Json(name = "author")
    val author: Profile,
    @Json(name = "body")
    val body: String,
    @Json(name = "createdAt")
    val createdAt: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "favorited")
    val favorited: Boolean,
    @Json(name = "favoritesCount")
    val favoritesCount: Int,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "tagList")
    val tagList: List<String>,
    @Json(name = "title")
    val title: String,
    @Json(name = "updatedAt")
    val updatedAt: String
)