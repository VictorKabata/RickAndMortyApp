package com.vickikbt.rickandmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vickikbt.rickandmortyapp.repository.CharactersRepository
import kotlinx.coroutines.Dispatchers

class CharactersViewModel : ViewModel() {
    private val repository = CharactersRepository()

    val myData = liveData(Dispatchers.IO) {
        val retrievedCharacters = repository.getData()
        emit(retrievedCharacters)
    }

}