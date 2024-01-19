package com.iti.kotlin_curso.components

import android.app.DatePickerDialog
import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.window.Dialog
import com.iti.kotlin_curso.databases.viewmodels.PersonasViewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ContentAlpha
import com.iti.kotlin_curso.databases.entities.Persona
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date


@Composable
fun DialogCrud(action: String, onDismiss: () -> Unit, viewModel: PersonasViewModel,allPersonas: List<Persona>) {
var persona = Persona()
    AlertDialog(
        icon = {
            Icon(Icons.Filled.Add, contentDescription = null)
        },
        title = { Text(text = "Insertar Persona")},
        onDismissRequest = { onDismiss() },
        text = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                // Ajustar el padding según sea necesario
                contentAlignment = Alignment.Center
            ) {
                if(action=="insert"){
                    insertForm(persona)
                }
                if(action=="delete"){
                    DeleteForm(allPersonas)
                }
            }

        },
        confirmButton = {insertDatabase(persona,viewModel,action)},
    )
}
@Composable
fun insertDatabase(persona:Persona,viewModel: PersonasViewModel,action:String){

    if(action=="insert"){
        Button(onClick = {  viewModel.insert(persona) }) {
            Text(text = "Insertar")
        }
    }
    if(action=="Delete"){
        Button(onClick = {  viewModel.insert(persona) }) {
            Text(text = "Insertar")
        }
    }

    Log.i("BBDD", "Insertado ${persona.toString()}" )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun insertForm(persona:Persona){
    var nombre by remember { mutableStateOf(persona.nombre ?: "") }

    var mail by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }

    val options = listOf("Male", "Female", "No answer")
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    LaunchedEffect(nombre, mail,sexo) {
        persona.nombre = nombre
        persona.mail = mail
        persona.sexo=sexo
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "Nombre") },
            value = nombre,
            onValueChange = {
                nombre = it
            },
            modifier = Modifier
                .focusRequester(focusRequester),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Next,
                    )
                }
            ),

            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Black,
                cursorColor = Color.Black,
                placeholderColor = Color.Black.copy(alpha = ContentAlpha.medium),
                disabledPlaceholderColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                disabledLabelColor = Color.Black,
                focusedBorderColor = if (nombre.isBlank()) Color.Red else Color.Black, // Color del borde cuando hay un error
                unfocusedBorderColor = if (nombre.isBlank()) Color.Red else Color.Black, // Mantén el borde rojo si hay error y el texto está vacío
                disabledBorderColor = Color.White
            ),


            )
        Spacer(modifier = Modifier.height(10.dp))

        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange ={expanded=it} )
            {
                TextField(
                   value = sexo,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)},
                    modifier = Modifier.menuAnchor()

                )
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = {expanded=false}) {

                    DropdownMenuItem(
                        text = {
                            Row {
                                Text("Hombre")

                            }
                        },
                        onClick = {
                            sexo = "Hombre"
                            expanded = false
                        },
                    )
                    DropdownMenuItem(
                        text = {
                            Row {
                                Text("Mujer")

                            }
                        },
                        onClick = {
                            sexo = "Mujer"
                            expanded = false
                        },
                    )


                }


            }
        OutlinedTextField(
            label = { Text(text = "Mail") },
            value = mail,
            onValueChange = {
              mail = it
            },
            modifier = Modifier
                .focusRequester(focusRequester),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Next,
                    )
                }
            ),

            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Black,
                cursorColor = Color.Black,
                placeholderColor = Color.Black.copy(alpha = ContentAlpha.medium),
                disabledPlaceholderColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                disabledLabelColor = Color.Black,
                focusedBorderColor = if (mail.isBlank()) Color.Red else Color.Black, // Color del borde cuando hay un error
                unfocusedBorderColor = if (mail.isBlank()) Color.Red else Color.Black, // Mantén el borde rojo si hay error y el texto está vacío
                disabledBorderColor = Color.White
            ),


            )








    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteForm(allPersonas: List<Persona>) {
    var selectedPersona by remember { mutableStateOf<Persona?>(null) }
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        TextField(
            readOnly = true,
            value = selectedPersona?.nombre ?: "Seleccione una persona",
            onValueChange = {},
            label = { Text("Seleccione una persona") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            allPersonas.forEach { persona ->
                DropdownMenuItem(
                    onClick = {
                        selectedPersona = persona
                        expanded = false
                    },
                    text = { Text(persona.nombre!!) }
                )
            }
        }
    }

    // Añadir aquí el botón de borrar si lo necesitas
}