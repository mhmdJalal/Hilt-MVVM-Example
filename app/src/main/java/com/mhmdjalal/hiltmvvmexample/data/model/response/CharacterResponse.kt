package com.mhmdjalal.hiltmvvmexample.data.model.response


import com.mhmdjalal.hiltmvvmexample.data.model.Info
import com.mhmdjalal.hiltmvvmexample.data.model.Character
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    @Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val results: List<Character>
)