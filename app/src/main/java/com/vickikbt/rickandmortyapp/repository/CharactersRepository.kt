package com.vickikbt.rickandmortyapp.repository

import com.vickikbt.rickandmortyapp.data.api.RetrofitInstance

class CharactersRepository {
    private val retrofitInstance=RetrofitInstance.retrofitService

    suspend fun getData()=retrofitInstance.getCharacters()
}