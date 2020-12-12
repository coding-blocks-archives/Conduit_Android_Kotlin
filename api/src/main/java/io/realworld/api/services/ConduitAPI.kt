package io.realworld.api.services

import io.realworld.api.models.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ConduitAPI {

    @GET("articles")
    fun getArticles(): Call<ArticlesResponse>
}