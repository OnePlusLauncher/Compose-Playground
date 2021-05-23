package com.example.composeplayground.screens.rickmorty.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

class RickMortyRepository {

    private interface RickMortyService {

        @GET("api/character")
        suspend fun getCharacters(): CharactersResponse
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    suspend fun getCharacters(): List<Character> {
        return retrofit.create<RickMortyService>().getCharacters().results
    }
}