package io.realworld.api.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.realworld.api.models.entities.Comment

@JsonClass(generateAdapter = true)
data class CommentResponse(
    @Json(name = "comment")
    val comments: Comment
)