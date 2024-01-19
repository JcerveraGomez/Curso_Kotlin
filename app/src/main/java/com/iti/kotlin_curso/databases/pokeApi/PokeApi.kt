package com.iti.kotlin_curso.databases.pokeApi

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.iti.kotlin_curso.databases.pokeApi.service.PokemonResponse
import com.iti.kotlin_curso.databases.pokeApi.service.RetrofitClient
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


@Composable
fun PokemonListScreen() {
    val pokemonList = remember { mutableStateListOf<String>() }

    LaunchedEffect(Unit) {
        RetrofitClient.service.listPokemons().enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                if (response.isSuccessful) {
                    response.body()?.results?.forEach { pokemon ->
                        pokemonList.add(pokemon.name)
                        Log.i("Pokemon", pokemon.toString())
                    }
                } else {
                    // Manejar respuesta no exitosa
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                // Manejar el error
            }
        })
    }

    Column {
        for (pokemon in pokemonList) {
            PokemonCard(pokemonName = pokemon)
        }
    }
}
@Composable
fun PokemonCard(pokemonName: String) {
    Card {
        Text(text = pokemonName)
    }
}