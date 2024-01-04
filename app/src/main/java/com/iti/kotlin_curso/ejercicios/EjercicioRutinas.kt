package com.iti.kotlin_curso.ejercicios

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.iti.kotlin_curso.components.customTopBar
import com.iti.kotlin_curso.ui.theme.LightOrange

// Clase de datos para representar una noticia
data class Noticia(val titulo: String, val contenido: String)

// ViewModel
class NoticiasViewModel : ViewModel() {
    private val _noticias = MutableLiveData<List<Noticia>>()
    val noticias: LiveData<List<Noticia>> = _noticias

    init {
        cargarNoticias()
    }

    private fun cargarNoticias() {
        viewModelScope.launch {
            // Simula una carga de datos
            delay(2000)
            _noticias.postValue(listOf(
                Noticia("Noticia 1", "Contenido de la noticia 1..."),
                Noticia("Noticia 2", "Contenido de la noticia 2..."),
                Noticia("Noticia 3", "Contenido de la noticia 3..."),
                Noticia("Noticia 4", "Contenido de la noticia 4..."),
                Noticia("Noticia 5", "Contenido de la noticia 5..."),
                Noticia("Noticia 6", "Contenido de la noticia 6..."),
                Noticia("Noticia 7", "Contenido de la noticia 7..."),
                Noticia("Noticia 8", "Contenido de la noticia 8..."),

                // Agrega más noticias aquí
            ))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaNoticias(noticiasViewModel: NoticiasViewModel?=NoticiasViewModel(),navController:NavController) {
    val noticias by noticiasViewModel!!.noticias.observeAsState(initial = emptyList())
    var progress by remember { mutableStateOf(0f) }

    Scaffold(
        topBar = {
            customTopBar(navController = navController)
        },        content = { innerpadding ->
            Box(modifier = Modifier.padding(innerpadding)) {
                if (noticias.isEmpty()) {
                    LinearProgressIndicator(progress = progress, modifier = Modifier.fillMaxWidth())
                    // Simulación del progreso de la barra
                    LaunchedEffect(key1 = Unit) {
                        while (progress < 1f) {
                            delay(100) // Incrementa el progreso cada 100 ms
                            progress += 0.05f
                        }
                    }
                } else {
                    ListaNoticias(noticias)
                }
            }

        }
    )
}

@Composable
fun ListaNoticias(noticias: List<Noticia>) {
    LazyColumn {
        items(noticias.size) { index ->
            TarjetaNoticia(noticias[index])
        }
    }
}

@Composable
fun TarjetaNoticia(noticia: Noticia) {
    Card(modifier = Modifier.padding(8.dp), colors = CardDefaults.cardColors(LightOrange.copy(0.3f))) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(noticia.titulo, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(noticia.contenido)
        }
    }
}


