package com.iti.kotlin_curso.databases.pokeApi.service

import retrofit2.http.GET
import retrofit2.Call


interface PokeApiService {
    @GET("pokemon?limit=80")
    fun listPokemons(): Call<PokemonResponse>
}

// Asegúrate de tener una clase para parsear la respuesta
data class PokemonResponse(val results: List<Pokemon>)
data class Pokemon(val name: String)