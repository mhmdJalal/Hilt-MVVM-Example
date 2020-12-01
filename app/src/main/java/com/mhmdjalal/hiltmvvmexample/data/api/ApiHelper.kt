package com.mhmdjalal.hiltmvvmexample.data.api

import com.mhmdjalal.hiltmvvmexample.data.model.User
import com.mhmdjalal.hiltmvvmexample.data.model.response.CharacterResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>

    suspend fun getCharacters(): Response<CharacterResponse>
}