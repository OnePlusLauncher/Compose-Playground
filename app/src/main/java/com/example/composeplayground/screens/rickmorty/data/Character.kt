package com.example.composeplayground.screens.rickmorty.data

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) {

    data class Location(
        val name: String,
        val url: String
    )
}

data class CharactersResponse(val results: List<Character>)