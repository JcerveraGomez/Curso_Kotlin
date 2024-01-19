package com.iti.kotlin_curso.databases

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.iti.kotlin_curso.components.DialogCrud
import com.iti.kotlin_curso.components.customTopBar
import com.iti.kotlin_curso.databases.database.AppDatabase
import com.iti.kotlin_curso.databases.entities.Persona
import com.iti.kotlin_curso.databases.repositories.PersonasRepository
import com.iti.kotlin_curso.databases.viewmodels.PersonasViewModel
import com.iti.kotlin_curso.databases.viewmodels.PersonasViewModelFactory
import com.iti.kotlin_curso.ejercicios.Noticia
import com.iti.kotlin_curso.ejercicios.TarjetaNoticia
import com.iti.kotlin_curso.ui.theme.LightOrange


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomCrud (navController:NavController){
        val viewModelPersonas: PersonasViewModel = viewModel(
        factory = PersonasViewModelFactory(
            PersonasRepository(
                AppDatabase.getDatabase(LocalContext.current).PersonasDao()
            )
        )
    )
    var typeOfDialog = remember { mutableStateOf("") }
    LaunchedEffect(Unit){
        Log.i("BBDD", "Lanzado")
    }

    val allpersonas by viewModelPersonas.allPersonas.observeAsState(listOf())
    Log.i("BBDD", allpersonas.toString())







    var showCrudDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            customTopBar(navController = navController)
        }

    ) { innerPadding ->
        if (showCrudDialog) {

            DialogCrud(typeOfDialog.value,
                onDismiss = { showCrudDialog = false
                    navController.navigate("RoomCrud")},
                viewModelPersonas,
                allpersonas

                )
        }
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = LightOrange.copy(alpha = 0.2f),
                        ),
                    ) {
                        Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                            Text(text = "Acciones")


                        }
                        Row(modifier = Modifier.padding(horizontal = 10.dp, 5.dp)) {
                            IconButton(onClick = { showCrudDialog = true
                                typeOfDialog.value="insert"}) {
                                Icon(Icons.Filled.Add, contentDescription =null )

                            }
                            IconButton(onClick = { showCrudDialog = true
                                typeOfDialog.value="delete"}) {
                                Icon(Icons.Filled.Delete, contentDescription =null )

                            }
                            IconButton(onClick = { showCrudDialog = true
                                typeOfDialog.value="update"}) {
                                Icon(Icons.Filled.Refresh, contentDescription =null )

                            }

                        }





                    }
                    LazyColumn {
                        items(allpersonas.size) { index ->
                            TarjetaPersona(allpersonas[index])
                        }
                    }
                }
            }


        }
    }


}

@Composable
fun TarjetaPersona(persona: Persona) {
    Card(modifier = Modifier.padding(8.dp), colors = CardDefaults.cardColors(LightOrange.copy(0.3f))) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(persona.nombre!!, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(persona.mail!!)
        }
    }
}