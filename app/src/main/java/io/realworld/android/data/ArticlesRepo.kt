package io.realworld.android.data

import io.realworld.api.ConduitClient
import io.realworld.api.models.entities.Article
import io.realworld.api.models.entities.ArticleData
import io.realworld.api.models.requests.UpsertArticleRequest

object ArticlesRepo {
    val api = ConduitClient.publicApi
    val authApi = ConduitClient.authApi

    suspend fun getGlobalFeed() = api.getArticles().body()?.articles
    suspend fun getMyFeed() = authApi.getFeedArticles().body()?.articles

    suspend fun createArticle(
        title:String?,
        description:String?,
        body:String?,
        tagList:List<String>?=null
    ) : Article? {
        val response =authApi.createArticle(
            UpsertArticleRequest(
            ArticleData(
                title=title,
                description = description,
                body = body,
                tagList = tagList
            )
        )
        )

        return response.body()?.article
    }
}