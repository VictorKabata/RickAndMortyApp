package com.vickikbt.rickandmortyapp.data.model


import com.google.gson.annotations.SerializedName

data class Characters(
    val info: Info,
    val results: List<Result>
)