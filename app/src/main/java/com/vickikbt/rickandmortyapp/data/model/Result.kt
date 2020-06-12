package com.vickikbt.rickandmortyapp.data.model


import com.google.gson.annotations.SerializedName

data class Result(
    val id: Int,
    val name: String,
    val gender: String,
    val image: String,
    val created: String,
    val episode: List<String>,
    val location: Location,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)