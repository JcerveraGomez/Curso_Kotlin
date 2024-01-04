package com.iti.kotlin_curso.databases

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.iti.kotlin_curso.databases.repositories.PersonasRepository
import com.iti.kotlin_curso.databases.viewmodels.PersonasViewModel
import com.iti.kotlin_curso.databases.viewmodels.PersonasViewModelFactory
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





    var showCrudDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            customTopBar(navController = navController)
        }

    ) { innerPadding ->
        if (showCrudDialog) {

            DialogCrud("insert",
                onDismiss = { showCrudDialog = false },
                viewModelPersonas,

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
                            IconButton(onClick = { showCrudDialog = true}) {
                                Icon(Icons.Filled.Add, contentDescription =null )

                            }

                        }



                    }
                }
            }
        }
    }


}