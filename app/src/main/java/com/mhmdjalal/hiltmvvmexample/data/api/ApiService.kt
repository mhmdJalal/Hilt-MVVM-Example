package com.mhmdjalal.hiltmvvmexample.data.api

import com.mhmdjalal.hiltmvvmexample.data.model.User
import com.mhmdjalal.hiltmvvmexample.data.model.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>

}