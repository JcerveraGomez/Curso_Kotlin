package com.iti.kotlin_curso.databases

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iti.kotlin_curso.components.customTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedPreferencesDemoScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("demo_preferences", Context.MODE_PRIVATE)
    var inputText = remember { mutableStateOf("") }
    var savedText = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        savedText.value = sharedPreferences.getString("saved_text", "") ?: ""
    }

    Scaffold(
        topBar = {
            customTopBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = inputText.value,
                onValueChange = { newValue -> inputText.value = newValue },
                label = { Text("Enter text") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    sharedPreferences.edit().putString("saved_text", inputText.value).apply()
                    savedText.value = inputText.value
                    inputText.value = ""
                }
            ) {
                Text("Save text", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    savedText.value = sharedPreferences.getString("saved_text", "") ?: ""
                }
            ) {
                Text("Load text", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Saved text: ${savedText.value}")
        }
    }
}