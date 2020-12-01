package com.mhmdjalal.hiltmvvmexample.data.repository

import com.mhmdjalal.hiltmvvmexample.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()

    suspend fun getCharacters() =  apiHelper.getCharacters()

    /*fun getCharacters(results: (Resource<CharacterResponse>) -> Unit) {
        request(scope, { apiHelper.getCharacters() }, {
            results(it)
        })
    }*/
}