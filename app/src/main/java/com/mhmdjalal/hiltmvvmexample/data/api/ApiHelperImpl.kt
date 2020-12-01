package com.mhmdjalal.hiltmvvmexample.data.api

import com.mhmdjalal.hiltmvvmexample.data.model.User
import com.mhmdjalal.hiltmvvmexample.data.model.response.CharacterResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

    override suspend fun getCharacters(): Response<CharacterResponse> = apiService.getCharacters()

}