package io.realworld.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.realworld.api.models.entities.ArticleData

@JsonClass(generateAdapter = true)
data class CreateArticleRequest(
    @Json(name = "article")
    val article: ArticleData
)