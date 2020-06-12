package com.vickikbt.rickandmortyapp.data.api

import com.vickikbt.rickandmortyapp.data.model.Characters
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): Response<Characters>
}