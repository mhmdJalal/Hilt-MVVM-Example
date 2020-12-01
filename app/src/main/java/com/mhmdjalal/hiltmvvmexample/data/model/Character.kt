package com.mhmdjalal.hiltmvvmexample.data.model


import com.squareup.moshi.Json

data class Character(
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "species")
    val species: String,
    @Json(name = "status")
    val status: String
)