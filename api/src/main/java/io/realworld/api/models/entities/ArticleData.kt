package io.realworld.api.models.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleData(
    @Json(name = "body")
    val body: String?=null,
    @Json(name = "description")
    val description: String?=null,
    @Json(name = "tagList")
    val tagList: List<String>?=null,
    @Json(name = "title")
    val title: String?=null
)