package com.iti.kotlin_curso.databases.pokeApi

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iti.kotlin_curso.components.customTopBar
import com.iti.kotlin_curso.databases.pokeApi.service.PokemonResponse
import com.iti.kotlin_curso.databases.pokeApi.service.RetrofitClient
import com.iti.kotlin_curso.ui.theme.LightOrange
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(navController: NavController) {
    val pokemonList = remember { mutableStateListOf<String>() }
    var filteredList = remember { mutableStateListOf<String>() }
    val isLoading = remember { mutableStateOf(true) } // Estado para el indicador de carga
    var searchText = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        RetrofitClient.service.listPokemons().enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                isLoading.value = false // Detiene el indicador de carga
                if (response.isSuccessful) {
                    response.body()?.results?.forEach { pokemon ->
                        pokemonList.add(pokemon.name)
                        filteredList.add(pokemon.name)
                        Log.i("Pokemon", pokemon.toString())
                    }
                } else {
                    // Manejar respuesta no exitosa
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                isLoading.value = false // Detiene el indicador de carga
                // Manejar el error
            }
        })
    }

    Scaffold(
        topBar = {
            customTopBar(navController = navController)
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize(1f)
            .padding(innerPadding)) {
            TextField(
                value = searchText.value,
                onValueChange = { newValue ->
                    searchText.value = newValue
                    filteredList.clear()
                    filteredList.addAll(pokemonList.filter { it.contains(newValue, ignoreCase = true) })
                },
                label = { Text("Buscar Pokemon") },
                modifier = Modifier.fillMaxWidth()
            )
            Box(modifier = Modifier.fillMaxSize()){
                if (isLoading.value) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(modifier = Modifier.size(50.dp))

                    }
                    // Muestra el indicador de carga
                } else {

                    LazyColumn {
                        items(filteredList) { pokemon ->
                            PokemonCard(pokemonName = pokemon)
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun PokemonCard(pokemonName: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp), // Agrega bordes redondeados
        colors = CardDefaults.cardColors(LightOrange.copy(alpha = 0.2f)),
    ) {
        Column(
            modifier = Modifier.padding(16.dp), // Agrega relleno alrededor del texto
            horizontalAlignment = Alignment.CenterHorizontally, // Centra el texto horizontalmente
            verticalArrangement = Arrangement.Center // Centra el texto verticalmente
        ) {
            Text(
                text = pokemonName,
                style = MaterialTheme.typography.bodyLarge, // Cambia el estilo del texto
                color = Color.Black // Cambia el color del texto
            )
        }
    }
}

