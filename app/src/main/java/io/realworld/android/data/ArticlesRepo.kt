package io.realworld.android.data

import io.realworld.api.ConduitClient

object ArticlesRepo {
    val api = ConduitClient().api

    suspend fun getGlobalFeed() = api.getArticles()
}