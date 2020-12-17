package io.realworld.android.data

import io.realworld.api.ConduitClient
import io.realworld.api.models.entities.LoginData
import io.realworld.api.models.requests.LoginRequest
import io.realworld.api.models.responses.UserResponse

object UserRepo {
    val api = ConduitClient.publicApi
    val authAPI = ConduitClient.authApi

    suspend fun login(email: String, password: String): UserResponse? {
        val response = api.loginUser(LoginRequest(LoginData(email, password)))

        ConduitClient.authToken = response.body()?.user?.token

        return response.body()
    }

    suspend fun getUserProfile() = authAPI.getCurrentUser().body()?.user

}