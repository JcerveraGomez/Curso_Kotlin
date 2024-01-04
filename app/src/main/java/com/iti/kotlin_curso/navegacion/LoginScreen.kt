package com.iti.kotlin_curso.navegacion

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.common.api.Scope
import com.iti.kotlin_curso.R
import com.iti.kotlin_curso.components.customTopBar
import com.iti.kotlin_curso.ui.theme.Orange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController, activity: Activity) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val imagePainter = painterResource(id = R.drawable.logo_iti)
    val username = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    //Es una estructura básica de diseño en Compose que proporciona una barra superior, un contenido y otras áreas comunes.
    Scaffold(
        topBar = {
            customTopBar(navController = navController)
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },


        ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                )
                OutlinedTextField(
                    label = { Text(text = "User", color = Color.Black) },
                    value = username.value,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { username.value = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Black,
                        cursorColor = Color.Black,
                        disabledPlaceholderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        disabledLabelColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        disabledBorderColor = Color.Black
                    )
                )
                OutlinedTextField(
                    label = { Text(text = "Contraseña", color = Color.Black) },
                    value = password.value,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { password.value = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Black,
                        cursorColor = Color.Black,
                        disabledPlaceholderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        disabledLabelColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        disabledBorderColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(25.dp))
                Button(
                    onClick = {
                        loginCheck(
                            navController,
                            username.value.text,
                            password.value.text,
                            scope,
                            snackbarHostState
                        )
                    },
                    shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(Orange),
                ) {
                    Text(text = "Login", color = Color.White)

                }

            }

        }


    }

}

fun loginCheck(
    navController: NavController,
    username: String,
    password: String,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    Log.i("DebugLogin", "UserName:${username} ---- Password:${password}")

    if (username == "test" && password == "test") {
        navController.navigate("Home")
        Log.i("DebugLogin", "LoginCompleto")
    } else {
        Log.e("DebugLogin", "ERROR EN EL LOGIN")
        scope.launch {
            snackbarHostState.showSnackbar(
                message = "Error",
                duration = SnackbarDuration.Short,
                actionLabel = "Cerrar",



            )
        }

    }


}