package ca.gbc.comp3074.olpindo_dharwynivor.lab9.network

import ca.gbc.comp3074.olpindo_dharwynivor.lab9.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderApi {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): User
}