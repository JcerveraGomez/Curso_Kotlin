package com.iti.kotlin_curso.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
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
import androidx.compose.runtime.LaunchedEffect
import androidx.wear.compose.material.ContentAlpha


@Composable
fun DialogCrud(action: String, onDismiss: () -> Unit, viewModel: PersonasViewModel) {
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
                    insertForm()
                }
            }

        },
        confirmButton = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun insertForm(){
    var nombre by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val options = listOf("Male", "Female","No answer")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    Column() {
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
                textColor = Color.White,
                disabledTextColor = Color.White,
                cursorColor = Color.White,
                placeholderColor = Color.White.copy(alpha = ContentAlpha.medium),
                disabledPlaceholderColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                disabledLabelColor = Color.White,
                focusedBorderColor = if (nombre.isBlank()) Color.Red else Color.White, // Color del borde cuando hay un error
                unfocusedBorderColor = if (nombre.isBlank()) Color.Red else Color.White, // Mantén el borde rojo si hay error y el texto está vacío
                disabledBorderColor = Color.White
            ),


            )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it },

            ) {

            OutlinedTextField(
                label = { Text(text = "Sexo") },

                readOnly = true,

                value = selectedOptionText,
                onValueChange = {
                    sexo = selectedOptionText
                },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    disabledTextColor = Color.White,
                    cursorColor = Color.White,
                    placeholderColor = Color.White.copy(alpha = ContentAlpha.medium),
                    disabledPlaceholderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    disabledLabelColor = Color.White,
                    focusedBorderColor = Color.White, // Color del borde cuando hay un error
                    unfocusedBorderColor = Color.White, // Mantén el borde rojo si hay error y el texto está vacío
                    disabledBorderColor = Color.White
                )

            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = {
                            Row {
                                Icon(Icons.Filled.Person, contentDescription = null)
                                Text(selectionOption)

                            }
                        },
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }

        }

    }

}